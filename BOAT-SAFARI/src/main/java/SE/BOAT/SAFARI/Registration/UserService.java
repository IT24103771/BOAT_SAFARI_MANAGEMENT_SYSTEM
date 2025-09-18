package SE.BOAT.SAFARI.Registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Register a new user
    public User registerUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            return null; // or throw an exception
        }
        return userRepository.save(user);
    }

    // Get all users (for admin panel)
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    // Find user by email (for login)
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
