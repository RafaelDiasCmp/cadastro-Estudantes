package com.abutua.student_backend.resources;

import java.util.List;
import java.net.URI;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.abutua.student_backend.models.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin
public class StudentController {

    private List<Student> students = new ArrayList<>();

    @PostMapping("students") //Botão Cadastrar/Salvar
    public ResponseEntity<Student> save(@RequestBody Student student) {
        student.setId(students.size() + 1);
        students.add(student);

        URI location = ServletUriComponentsBuilder // URI == /students/ID
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(student.getId())
                .toUri();

        return ResponseEntity.created(location).body(student);

    }

    @GetMapping("students/{id}") // Endpoint
    public ResponseEntity<Student> getStudent(@PathVariable int id) {
        
        // Filtro para retornar status code correto
        Student stdt = students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found!"));

        return ResponseEntity.ok(stdt); // Usuário usa id 1, recebe estudante 1 (pos 0)
    }

    @GetMapping("students")
    public List<Student> getStudents() { // lista com vários estudantes

        return students;
    }
}
