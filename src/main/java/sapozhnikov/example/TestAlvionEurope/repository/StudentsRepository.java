package sapozhnikov.example.TestAlvionEurope.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sapozhnikov.example.TestAlvionEurope.models.Student;

import java.util.List;

@Repository
public interface StudentsRepository extends JpaRepository<Student, Long> {
    List<Student> getAllBy();

    Student getStudentById(long id);

}
