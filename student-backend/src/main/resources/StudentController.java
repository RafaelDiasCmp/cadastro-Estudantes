import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    



    
    @GetMapping("students")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
}
