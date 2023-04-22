package sapozhnikov.example.TestAlvionEurope.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Table(name = "students_record_book")
@Entity
public class StudentRecordBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long idRecordBook;
    private int math;
    private int russianLanguage;
    private int englishLanguage;
    private int programming;

    @Override
    public String toString() {
        return "StudentRecordBook{" +
                "id=" + id +
                ", idRecordBook=" + idRecordBook +
                ", math=" + math +
                ", russianLanguage=" + russianLanguage +
                ", englishLanguage=" + englishLanguage +
                ", programming=" + programming +
                '}';
    }
}
