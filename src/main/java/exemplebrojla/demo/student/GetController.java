package exemplebrojla.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Users")
@CrossOrigin(origins = "http://localhost:4200")
public class GetController {

    private final RegistrationRepository registrationRepository;

    @Autowired
    public GetController(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    @GetMapping
    public ResponseEntity<List<Registration>> getUsers() {

        List<Registration> registrations = registrationRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(registrations);

    }
}
