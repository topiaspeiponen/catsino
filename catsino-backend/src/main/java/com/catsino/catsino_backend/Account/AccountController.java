package com.catsino.catsino_backend.Account;

import org.springframework.web.bind.annotation.RestController;

import com.catsino.catsino_backend.User.User;
import com.catsino.catsino_backend.User.UserRepository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class AccountController {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public AccountController(AccountRepository accountRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("accounts")
    public Iterable<Account> findAllAccounts() {
        return this.accountRepository.findAll();
    }

    @GetMapping("accounts/{id}")
    public Optional<Account> findOneUser(@PathVariable UUID id) {
        return this.accountRepository.findById(id);
    }

    @PostMapping("accounts")
    public ResponseEntity<String> createAccount(@RequestBody AccountDTO accountDTO) {
        Optional<User> userOptional = userRepository.findById(accountDTO.getUserId());

        if (userOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("User not found");
        }

        User user = userOptional.get();

        // Create a new Account
        Account account = new Account();
        account.setUser(user);
        account.setBalance(500); // Set initial balance
        account.setAllTimeHigh(500); // Set initial all-time high
        account.setActive(true); // Default to active

        // Save to the database
        accountRepository.save(account);

        return ResponseEntity.ok("Account created successfully");
    }
    
}
