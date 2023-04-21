package sapozhnikov.example.TestAlvionEurope.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class StudentServiceException extends Exception {
    private String exception;

    @Override
    public String toString() {
        return "StudentServiceException{" +
                "exception='" + exception + '\'' +
                '}';
    }
}
