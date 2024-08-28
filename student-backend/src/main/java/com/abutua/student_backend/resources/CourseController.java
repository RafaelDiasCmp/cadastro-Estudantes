package com.abutua.student_backend.resources;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Arrays;

import com.abutua.student_backend.models.Course;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@CrossOrigin
public class CourseController {

    private List<Course> courses = Arrays.asList(         
        new Course(1, "Angular"),
        new Course(2, "Bootstrap"),
        new Course(3, "Git/GitHub"));
    
    
    
    @GetMapping("courses/{id}") //Endpoint
    public ResponseEntity<Course> getCourse(@PathVariable int id){ 
    // PathVariable Notação que indica o parâmetro getCourse pega o id que veio do endpoint
        

    //Filtro para retornar status code correto
    //200 se Sucesso
    //404 se Error
        Course crs = courses.stream()
            .filter(c -> c.getId() == id)
            .findFirst()
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found!"));
        
        return ResponseEntity.ok(crs); //Usuário usa id 1, recebe curso 1 (pos 0) 
    }


    @GetMapping("courses")
    public List<Course> getCourses(){ //lista com os cursos

        return courses;
    }
    
}
