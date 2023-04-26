package sapozhnikov.example.TestAlvionEurope.business_reports;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TableRow {
    private String FIOProfessor;
    private Integer studentsCount;
    private Double avgStudentsRating;
}
