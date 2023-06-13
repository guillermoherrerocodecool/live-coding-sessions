package com.codecool.securityjwt.runner;

import com.codecool.securityjwt.data.User;
import com.codecool.securityjwt.data.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
public class UsersPopulator {

    @Bean
    ApplicationRunner populateUsers(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            String password = passwordEncoder.encode("123");
            User user = new User(0, "el", password, Set.of("USER"));
            userRepository.save(user);
        };
    }
}
