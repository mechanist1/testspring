package exemplebrojla.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/signin")
public class signinController {
    private UsersRepository usersRepository;


    @Autowired
    public signinController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
    @PostMapping
    public ResponseEntity<String> signin(@RequestBody User user) {
        System.out.println("api for signin works");
        Optional<User> existingUser = usersRepository.findByEmail(user.getEmail());

        if (existingUser.isPresent() && existingUser.get().getpassword().equals(user.getpassword())) {

            return ResponseEntity.ok("user exists welcome");
        } else {


            return ResponseEntity.ok("doesn't exist");
        }
    }


}
