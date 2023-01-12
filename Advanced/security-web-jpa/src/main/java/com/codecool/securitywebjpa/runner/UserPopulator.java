package com.codecool.securitywebjpa.runner;

import com.codecool.securitywebjpa.persistence.User;
import com.codecool.securitywebjpa.persistence.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
public class UserPopulator {

    @Bean
    ApplicationRunner populateUsers(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            User user = new User();
            user.setUsername("user");
            user.setPassword(passwordEncoder.encode("123"));
            user.setAuthorities(Set.of("USER"));

            userRepository.save(user);

            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("123"));
            admin.setAuthorities(Set.of("USER", "ADMIN"));

            userRepository.save(admin);
        };
    }
}
