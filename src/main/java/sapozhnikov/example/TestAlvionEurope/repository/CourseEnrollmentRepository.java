package sapozhnikov.example.TestAlvionEurope.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sapozhnikov.example.TestAlvionEurope.models.CourseEnrollment;

import java.util.List;

public interface CourseEnrollmentRepository extends JpaRepository<CourseEnrollment, Long> {
    List<CourseEnrollment> getAllBy();
}
