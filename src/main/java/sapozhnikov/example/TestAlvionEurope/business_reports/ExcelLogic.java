package sapozhnikov.example.TestAlvionEurope.business_reports;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sapozhnikov.example.TestAlvionEurope.models.*;
import sapozhnikov.example.TestAlvionEurope.repository.*;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ExcelLogic {
    private final ProfessorRepository professorRepository;
    private final StudentsRepository studentsRepository;
    private final CourseEnrollmentRepository courseEnrollmentRepository;
    private final StudentRecordBookRepository studentRecordBookRepository;
    private final CourseRepository courseRepository;

    public List<TableRow> getRows() {
        List<TableRow> tableRows = new ArrayList<>();

        List<Professor> professors = this.professorRepository.getAllBy();
        List<Student> students = this.studentsRepository.getAllBy();
        List<CourseEnrollment> courseEnrollments = this.courseEnrollmentRepository.getAllBy();
        List<Course> courses = this.courseRepository.getAllBy();
        List<StudentRecordBook> studentRecordBooks = this.studentRecordBookRepository.getAllBy();

        for (Professor professor : professors) {
            int countStudents = this.getCountStudentsForProfessor(professor, students, courseEnrollments, courses);
            double avgRatingStudents = this.getAvgRatingStudentsForProfessor(professor, students,
                    courseEnrollments, courses, studentRecordBooks);
            tableRows.add(new TableRow(professor.getName(), countStudents, avgRatingStudents));
        }
        return tableRows;

    }

    private double getAvgRatingStudentsForProfessor(Professor professor,
                                                    List<Student> students,
                                                    List<CourseEnrollment> courseEnrollments,
                                                    List<Course> courses,
                                                    List<StudentRecordBook> studentRecordBooks) {
        int count = 0;
        int avgSum = 0;
        for (CourseEnrollment courseEnrollment : courseEnrollments) {
            for (Student student : students) {
                if (courseEnrollment.getIdStudent() == student.getId()) {
                    for (Course course : courses) {
                        if (courseEnrollment.getIdCourse() == course.getId()) {
                            if (course.getIdProfessorLector() != null && professor.getId() == course.getIdProfessorLector()) {
                                for (StudentRecordBook studentRecordBook : studentRecordBooks) {
                                    if (studentRecordBook.getId() == student.getIdRecordBook()) {
                                        count++;
                                        avgSum += studentRecordBook.getMath();
                                        avgSum += studentRecordBook.getProgramming();
                                        avgSum += studentRecordBook.getEnglishLanguage();
                                        avgSum += studentRecordBook.getRussianLanguage();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (count != 0) {
            return (double) avgSum / count;
        } else {
            return 0;
        }

    }

    private int getCountStudentsForProfessor(Professor professor,
                                             List<Student> students,
                                             List<CourseEnrollment> courseEnrollments,
                                             List<Course> courses) {
        int count = 0;
        for (CourseEnrollment courseEnrollment : courseEnrollments) {
            for (Student student : students) {
                if (courseEnrollment.getIdStudent() == student.getId()) {
                    for (Course course : courses) {
                        if (courseEnrollment.getIdCourse() == course.getId()) {
                            if (course.getIdProfessorLector() != null && professor.getId() == course.getIdProfessorLector()) {
                                count++;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
