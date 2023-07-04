package exemplebrojla.demo.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import java.util.ArrayList;

@RestController
@RequestMapping("/Registration")
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationController {
    private final RegistrationRepository registrationRepository;

    @Autowired
    public RegistrationController(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }


    @PostMapping
    public ResponseEntity<String> register(@RequestBody Registration r){
        registrationRepository.save(r);
        System.out.println("requestbody recieved");
        String res=r.getFirstname();
        System.out.println("this is the firstname: "+res);
        return ResponseEntity.status(HttpStatus.OK).body(res);


    }
    @DeleteMapping("/{id}")
    public void deleteRegistration(@PathVariable Long id) {
        registrationRepository.deleteById(id);
    }



}
