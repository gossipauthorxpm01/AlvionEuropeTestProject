package sapozhnikov.example.TestAlvionEurope.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.support.SQLErrorCodes;
import org.springframework.stereotype.Service;
import sapozhnikov.example.TestAlvionEurope.exceptions.StudentServiceException;
import sapozhnikov.example.TestAlvionEurope.models.Student;
import sapozhnikov.example.TestAlvionEurope.repository.StudentsRepository;

import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLWarning;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentService {
    private final StudentsRepository studentsRepository;

    public String addStudent(Student student) {
        List<Student> students = this.studentsRepository.getAllBy();
        if (!this.isStudentInBase(student, students)) {
            this.studentsRepository.save(student);
            return "Студент успешно добавлен в базу данных";
        } else {
            return "Операция отменена, студент с данными уникальными полями находится в базе данных";
        }
    }


    public String deleteStudent(int id) {
        Student student = this.studentsRepository.getStudentById(id);
        if(student == null){
            log.error("Операция отменена. Студент по id - {} не найден", id);
            return String.format("Операция отменена. Студент по id - %s не найден", id);
        }
        studentsRepository.delete(student);
        log.info("Студент с id - {} удален из системы", id);
        return String.format("Студент с id - %s удален из системы", id);
    }

    private boolean isStudentInBase(Student student, List<Student> students) {
        try {
            for (Student uniqueStudent : students) {
                if (uniqueStudent.getId() == student.getId()) {
                    throw new StudentServiceException(String.format("Студент с данный id - %s уже" +
                            " находиться в системе", student.getId()));
                }
                if (uniqueStudent.getEmail().equals(student.getEmail())) {
                    throw new StudentServiceException(String.format("Студент с данным email - %s уже" +
                            " находиться в системе", student.getEmail()));
                }
                if (uniqueStudent.getPhoneNumber().equals(student.getPhoneNumber())) {
                    throw new StudentServiceException(String.format("Студент с данным phoneNumber - %s уже" +
                            " находиться в системе", student.getPhoneNumber()));
                }
                if (uniqueStudent.getIdRecordBook() == student.getIdRecordBook()) {
                    throw new StudentServiceException(String.format("Студент с данным idRecordBook - %s уже" +
                            " находиться в системе", student.getIdRecordBook()));
                }
            }
            return false;
        } catch (StudentServiceException error) {
            log.error(error.toString());
            return true;
        }
    }
}
