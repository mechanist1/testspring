package exemplebrojla.demo.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Registration")
public class RegistrationController {
    private final RegistrationRepository registrationRepository;

    @Autowired
    public RegistrationController(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }


    @PostMapping
    public void register(@RequestBody Registration r){
        registrationRepository.save(r);

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
