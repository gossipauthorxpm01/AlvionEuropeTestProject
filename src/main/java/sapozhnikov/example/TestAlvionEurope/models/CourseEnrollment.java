package sapozhnikov.example.TestAlvionEurope.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Table(name = "course_enrollments")
public class CourseEnrollment {
    private long idStudent;
    private long idCourse;

    @Override
    public String toString() {
        return "CourseEnrollment{" +
                "idStudent=" + idStudent +
                ", idCourse=" + idCourse +
                '}';
    }
}
