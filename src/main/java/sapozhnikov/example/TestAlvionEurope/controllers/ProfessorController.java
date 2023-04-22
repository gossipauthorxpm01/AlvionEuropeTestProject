package sapozhnikov.example.TestAlvionEurope.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    @CrossOrigin(origins = "http://localhost:3000/")
    @DeleteMapping("/api/professor/delete-professor/{id}")
    public String deleteProfessor(@PathVariable int id) {
        return this.professorService.deleteProfessor(id);
    }

    @PostMapping("/api/professor/update-professor/")
    public void changeProfessor(@RequestBody Professor professor){
        this.professorService.changeProfessor(professor);
    }

}
