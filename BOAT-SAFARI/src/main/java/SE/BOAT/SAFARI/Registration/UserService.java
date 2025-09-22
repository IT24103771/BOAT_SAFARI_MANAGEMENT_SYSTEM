package SE.BOAT.SAFARI.Registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        String email = user.getEmail().trim();
        String password = user.getPassword().trim();

        if (userRepository.existsByEmail(email)) {
            return null;
        }

        user.setEmail(email);
        user.setPassword(password);
        user.setRole("USER");
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User login(User loginUser) {
        String email = loginUser.getEmail().trim();
        String password = loginUser.getPassword().trim();

        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getPassword().trim().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
