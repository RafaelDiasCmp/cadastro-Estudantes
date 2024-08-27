package com.abutua.student_backend.resources;

import java.util.List;

//import java.util.ArrayList;

import java.util.Arrays;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.abutua.student_backend.models.Student;

//import jakarta.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class StudentController {
    
    private List<Student> students = Arrays.asList( 
        new Student(1,"Rafael","raffael@gmail.com","15 98989-8989", 1, 1),
        new Student(2,"Dias","dias@gmail.com","15 98989-8989", 2, 2),
        new Student(3,"Campos","campos@gmail.com","15 98989-8989", 3, 3));

    // @PostConstruct // Garante momento certo de popular a lista
    // public void init() {

    //     // Objetos da classe Student
    //     Student s1 = new Student();
    //     s1.setId(1);
    //     s1.setName("Rafael");
    //     s1.setEmail("raffaeldiascampos@gmail.com");
    //     s1.setPhone("15981227765");
    //     s1.setIdCurso(1);
    //     s1.setPeriodo(1);

    //     Student s2 = new Student();
    //     s2.setId(2);
    //     s2.setName("Campos");
    //     s2.setEmail("campos@gmail.com");
    //     s2.setPhone("15981227765");
    //     s2.setIdCurso(2);
    //     s2.setPeriodo(2);

    //     Student s3 = new Student();
    //     s3.setId(3);
    //     s3.setName("Rafael");
    //     s3.setEmail("rafa@gmail.com");
    //     s3.setPhone("151312313");
    //     s3.setIdCurso(3);
    //     s3.setPeriodo(3);

    //     students.add(s1);
    //     students.add(s2);
    //     students.add(s3);
    // }



    @GetMapping("students/{id}") //Endpoint
    public ResponseEntity<Student> getStudent(@PathVariable int id){ 
    // PathVariable Notação que indica o parâmetro getStudent pega o id que veio do endpoint
        

    //Filtro para retornar status code correto
    //200 se Sucesso
    //404 se Error
        Student stdt = students.stream()
            .filter(s -> s.getId() == id)
            .findFirst()
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found!"));
        
        return ResponseEntity.ok(stdt); //Usuário usa id 1, recebe studante 1 (pos 0) 
    }


    @GetMapping("students")
    public List<Student> getStudents(){ //lista com vários estudantes

        return students;
    }
}
