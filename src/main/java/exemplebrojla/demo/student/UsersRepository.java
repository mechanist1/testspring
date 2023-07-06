package exemplebrojla.demo.student;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);

}
