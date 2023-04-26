package sapozhnikov.example.TestAlvionEurope.business_reports;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.List;

@Data
@Component
@RequiredArgsConstructor
@AllArgsConstructor
public class ExcelConverter {
    private String fileName = "business-reports/excel-report.xlsx";
    private Workbook workbook = new XSSFWorkbook();
    @Autowired
    private ExcelLogic excelLogic;

    public void createReport() throws IOException {
        Sheet sheet = this.workbook.createSheet("Отчет по загрузке профессоров");
        Row row = sheet.createRow(0);
        Cell cellFIO = row.createCell(0);
        cellFIO.setCellValue("ФИО профессора");
        Cell studentsCount = row.createCell(1);
        studentsCount.setCellValue("Количество студентов");
        Cell avgStudentsRating = row.createCell(2);
        avgStudentsRating.setCellValue("Средняя успеваемость студентов");
        List<TableRow> tableRowList = this.excelLogic.getRows();
        for (int i = 1; i < tableRowList.size(); i++) {
            Row rowData = sheet.createRow(i);
            Cell fioData = rowData.createCell(0);
            Cell studentsCountData = rowData.createCell(1);
            Cell avgStudentsRatingData = rowData.createCell(2);

            fioData.setCellValue(tableRowList.get(i).getFIOProfessor());
            studentsCountData.setCellValue(tableRowList.get(i).getStudentsCount());
            avgStudentsRatingData.setCellValue(tableRowList.get(i).getAvgStudentsRating());

        }

        sheet.autoSizeColumn(0);
        sheet.autoSizeColumn(1);
        sheet.autoSizeColumn(2);

        this.workbook.write(new FileOutputStream(this.fileName));
        this.workbook.close();
    }


}
