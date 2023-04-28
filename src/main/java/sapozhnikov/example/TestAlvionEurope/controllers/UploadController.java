package sapozhnikov.example.TestAlvionEurope.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import sapozhnikov.example.TestAlvionEurope.business_reports.ExcelConverter;

import java.io.IOException;

@RestController
@AllArgsConstructor
@Slf4j
public class UploadController {
    private ExcelConverter excelConverter;

    @PostMapping("/api/get-report/")
    public FileSystemResource getExcelReport() throws IOException {
        excelConverter.createReport();

        return new FileSystemResource("business-reports/excel-report.xlsx");
    }
}
