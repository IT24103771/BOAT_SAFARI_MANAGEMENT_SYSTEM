package SE.BOAT.SAFARI.Registration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByEmail(String email);

    // Add this line to allow finding a user by email
    Optional<User> findByEmail(String email);
}
