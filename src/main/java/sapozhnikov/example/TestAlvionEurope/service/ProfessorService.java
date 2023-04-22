package sapozhnikov.example.TestAlvionEurope.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import sapozhnikov.example.TestAlvionEurope.exceptions.ProfessorServiceException;
import sapozhnikov.example.TestAlvionEurope.models.Professor;
import sapozhnikov.example.TestAlvionEurope.repository.ProfessorRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProfessorService {
    private final ProfessorRepository professorRepository;

    public String addProfessor(Professor professor) {
        if (!this.isProfessorInBase(professor)) {
            this.professorRepository.save(professor);
            log.info("Профессор {} успешно добавлен в систему", professor);
            return "Профессор успешно добавлен в систему";
        }
        return "Профессор с данными уникальными полями находится в системе";

    }

    public String deleteProfessor(int id) {
        try {
            Professor professor = this.professorRepository.getById(id);
            if (professor == null) {
                throw new ProfessorServiceException(String.format("Профессор с данными id %s не найден в системе", id));
            }
            this.professorRepository.delete(professor);
            log.info("Профессор с данным id {} успешно удален из системы", id);
            return String.format("Профессор с данным id %s успешно удален из системы", id);
        } catch (ProfessorServiceException error) {
            log.error(error.toString());
            return String.format("Профессор с данным id %s не найден в системе", id);
        }

    }

    public Professor getProfessor(Long id) {
        try {
            return this.professorRepository.findById(id).get();
        } catch (NoSuchElementException error) {
            return null;
        }

    }

    public List<Professor> getAllProfessors() {
        return this.professorRepository.getAllBy();
    }

    public void changeProfessor(Professor professor) {
        this.professorRepository.save(professor);
    }

    private boolean isProfessorInBase(Professor professor) {
        List<Professor> professors = this.professorRepository.getAllBy();
        try {
            for (Professor uniqueProfessor : professors) {
                if (uniqueProfessor.getId() == professor.getId()) {
                    throw new ProfessorServiceException(String.format("Профессор с данным id - %s уже находится в системе", professor.getId()));
                }
                if (uniqueProfessor.getPhoneNumber().equals(professor.getPhoneNumber())) {
                    throw new ProfessorServiceException(String.format("Профессор с данным phoneNumber - %s уже находится в системе", professor.getPhoneNumber()));
                }
            }
            return false;
        } catch (ProfessorServiceException error) {
            log.error(error.toString());
            return true;
        }

    }



}
