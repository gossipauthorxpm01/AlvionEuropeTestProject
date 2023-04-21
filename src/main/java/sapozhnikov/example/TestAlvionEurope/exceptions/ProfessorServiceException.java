package sapozhnikov.example.TestAlvionEurope.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class ProfessorServiceException extends Exception {
    private String text;

    @Override
    public String toString() {
        return "ProfessorServiceException{" +
                "text='" + text + '\'' +
                '}';
    }
}
