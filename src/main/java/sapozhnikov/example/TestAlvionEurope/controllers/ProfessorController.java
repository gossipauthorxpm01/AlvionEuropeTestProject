package sapozhnikov.example.TestAlvionEurope.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import sapozhnikov.example.TestAlvionEurope.models.Professor;
import sapozhnikov.example.TestAlvionEurope.service.ProfessorService;

@RestController
@Slf4j
@AllArgsConstructor
public class ProfessorController {
    private final ProfessorService professorService;

    @PostMapping("/api/professor/add-professor/")
    public String addProfessor(@RequestBody Professor professor) {
        return this.professorService.addProfessor(professor);
    }

    @DeleteMapping("/api/professor/delete-professor/{id}")
    public String deleteProfessor(@PathVariable int id) {
        return this.professorService.deleteProfessor(id);
    }

}
