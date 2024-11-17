package xyz.pavanhegde.userservice.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final Logger log = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        log.info("Creating user: {}", user);
        return userRepository.save(user);
    }

    public User getUser(Long id) {
        log.info("Getting user with id: {}", id);
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(Long id, User user) {
        log.info("Updating user with id: {}", id);
        User existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        existingUser.setDateOfBirth(user.getDateOfBirth());
        return userRepository.save(existingUser);
    }

    public void deleteUser(Long id) {
        log.info("Deleting user with id: {}", id);
        userRepository.deleteById(id);
    }

    public List<User> getAllUsers() {
        log.info("Getting all users");
        return userRepository.findAll();
    }
}
