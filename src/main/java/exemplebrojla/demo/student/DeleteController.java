    package exemplebrojla.demo.student;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @RestController
    @RequestMapping("/Users")
    @CrossOrigin(origins = "http://localhost:4200")
    public class DeleteController {

        private final RegistrationRepository registrationRepository;

        @Autowired
        public DeleteController(RegistrationRepository registrationRepository) {
            this.registrationRepository = registrationRepository;
        }

        @DeleteMapping("/{id}")
        public void deleteUser (@PathVariable long id){
            System.out.println("deleted the id="+id);
            registrationRepository.deleteById(id);
        }
    }
