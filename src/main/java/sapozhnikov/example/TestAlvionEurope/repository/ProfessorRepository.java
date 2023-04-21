package sapozhnikov.example.TestAlvionEurope.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sapozhnikov.example.TestAlvionEurope.models.Professor;

import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    Professor getById(long id);
    List<Professor> getAllBy();

}
