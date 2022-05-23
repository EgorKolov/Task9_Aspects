package Task6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@Controller
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @GetMapping(value="/api")
    public ResponseEntity<String> mapApi(@RequestParam(value="name", defaultValue="world") String name) {
        return new ResponseEntity<>("Hello, " + name + "!", HttpStatus.OK);
    }
}
