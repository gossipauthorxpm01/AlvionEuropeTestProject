package sapozhnikov.example.TestAlvionEurope.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Table(name = "course_enrollments")
@Entity
public class CourseEnrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long idStudent;
    private long idCourse;

    @Override
    public String toString() {
        return "CourseEnrollment{" +
                "id=" + id +
                ", idStudent=" + idStudent +
                ", idCourse=" + idCourse +
                '}';
    }
}
