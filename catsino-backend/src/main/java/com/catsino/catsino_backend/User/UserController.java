package com.catsino.catsino_backend.User;

import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;
import java.util.UUID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("users")
    public Iterable<User> findAllUsers() {
        return this.userRepository.findAll();
    }

    @GetMapping("users/{id}")
    public Optional<User> findOneUser(@PathVariable UUID id) {
        return this.userRepository.findById(id);
    }

    @PostMapping("users")
    public User addOneUser(@RequestBody User user) {
        return this.userRepository.save(user);
    }
    
}
