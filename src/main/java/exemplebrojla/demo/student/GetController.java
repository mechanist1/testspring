package exemplebrojla.demo.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class GetController {

    private RegistrationRepository registrationRepository;
    @Autowired
    public GetController(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }
    @GetMapping("/")
    public ResponseEntity<List<Registration>> getregistrations(){
        List<Registration> l =registrationRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(l);

    }
}
