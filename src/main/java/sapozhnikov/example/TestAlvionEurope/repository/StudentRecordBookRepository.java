package sapozhnikov.example.TestAlvionEurope.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sapozhnikov.example.TestAlvionEurope.models.StudentRecordBook;

import java.util.List;

public interface StudentRecordBookRepository extends JpaRepository<StudentRecordBook, Long> {
    List<StudentRecordBook> getAllBy();
}
