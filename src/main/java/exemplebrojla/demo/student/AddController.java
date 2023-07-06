package exemplebrojla.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signup")
public class AddController {

    private UsersRepository usersRepository;

    @Autowired
    public AddController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @PostMapping
    public ResponseEntity<String> add(@RequestBody User res){

        usersRepository.save(res);
        return ResponseEntity.status(HttpStatus.OK).body("User saved");
    }


}
