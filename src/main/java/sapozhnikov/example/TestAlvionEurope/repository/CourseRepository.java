package sapozhnikov.example.TestAlvionEurope.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sapozhnikov.example.TestAlvionEurope.models.Course;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> getAllBy();

}
