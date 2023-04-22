package sapozhnikov.example.TestAlvionEurope.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.web.bind.annotation.*;
import sapozhnikov.example.TestAlvionEurope.models.Professor;
import sapozhnikov.example.TestAlvionEurope.service.ProfessorService;

import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
public class ProfessorController {
    private final ProfessorService professorService;
    @GetMapping("/api/professor/get-professor/{id}")
    public Professor getProfessor(@PathVariable Long id){
        return this.professorService.getProfessor(id);
    }
    @GetMapping("/api/professor/get-all-professors/")
    public List<Professor> getAllProfessors(){
        return this.professorService.getAllProfessors();
    }

    @PostMapping("/api/professor/add-professor/")
    public String addProfessor(@RequestBody Professor professor) {
        return this.professorService.addProfessor(professor);
    }

    @DeleteMapping("/api/professor/delete-professor/{id}")
    public String deleteProfessor(@PathVariable int id) {
        return this.professorService.deleteProfessor(id);
    }

}
