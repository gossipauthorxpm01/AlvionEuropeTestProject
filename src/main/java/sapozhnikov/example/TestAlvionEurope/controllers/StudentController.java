package sapozhnikov.example.TestAlvionEurope.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import sapozhnikov.example.TestAlvionEurope.models.Student;
import sapozhnikov.example.TestAlvionEurope.service.StudentService;

import java.sql.SQLIntegrityConstraintViolationException;

@Slf4j
@AllArgsConstructor
@RestController()
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/api/add-student/")
    public String addStudent(@RequestBody Student student) {
        return this.studentService.addStudent(student);
    }

    @DeleteMapping(value = "/api/delete-student/{id}")
    public String deleteStudent(@PathVariable int id) {
        return this.studentService.deleteStudent(id);
    }
}
