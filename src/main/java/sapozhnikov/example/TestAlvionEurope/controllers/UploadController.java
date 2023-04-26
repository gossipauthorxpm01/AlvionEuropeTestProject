package sapozhnikov.example.TestAlvionEurope.controllers;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sapozhnikov.example.TestAlvionEurope.business_reports.ExcelConverter;

import java.io.File;
import java.io.IOException;

@RestController
@AllArgsConstructor
@Slf4j
public class UploadController {
    private ExcelConverter excelConverter;

    @GetMapping("/api/get-report/")
    public File getExcelReport() throws IOException {
        excelConverter.createReport();
        return new File("business-reports/excel-report.xlsx");
    }
}
