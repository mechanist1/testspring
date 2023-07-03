package exemplebrojla.demo.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        System.out.println("This is the request body: " + r);
        String res="its working";
        return ResponseEntity.status(HttpStatus.OK).body(res);


    }
    @DeleteMapping("/{id}")
    public void deleteRegistration(@PathVariable Long id) {
        registrationRepository.deleteById(id);
    }
    @GetMapping("/{id}")
    public Registration get(@PathVariable Long id ){
        return registrationRepository.findById(id).orElse(null);
}

}
