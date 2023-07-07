package exemplebrojla.demo.student;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Key;
import java.util.Optional;

@RestController
@RequestMapping("/signin")
public class signinController {

    private UsersRepository usersRepository;

    private Key secretKey;

    @Autowired
    public signinController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
        this.secretKey = generateSecretKey();
    }

    @PostMapping
    public ResponseEntity<String> signin(@RequestBody User user) {
        System.out.println("API for signin works");
        Optional<User> existingUser = usersRepository.findByEmail(user.getEmail());

        if (existingUser.isPresent() && existingUser.get().getpassword().equals(user.getpassword())) {
            // User with the provided email and password exists
            String token = generateToken(existingUser.get().getEmail());
            return ResponseEntity.ok(token);
        } else {
            // User doesn't exist or the password doesn't match
            return ResponseEntity.ok("Invalid credentials");
        }
    }

    public static String generateToken(String subject) {
        return Jwts.builder()
                .setSubject(subject)
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key generateSecretKey() {
        return Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }

    private static Key getSigningKey() {
        return Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }
}
