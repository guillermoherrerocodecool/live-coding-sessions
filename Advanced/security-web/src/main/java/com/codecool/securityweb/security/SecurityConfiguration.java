package com.codecool.securityweb.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().and().cors().disable()
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/messages").permitAll();
                    auth.requestMatchers("/messages/user").hasRole("USER");
                    auth.requestMatchers("/messages/admin").hasRole("ADMIN");
                })
                .httpBasic(Customizer.withDefaults())
                .build();
    }
    
    @Bean
    UserDetailsService inMemoryUserDetailsManager() {
        UserDetails user = User.builder().username("user")
                .password(passwordEncoder().encode("123"))
                .roles("USER")
                .build();
        UserDetails admin = User.builder().username("admin")
                .password(passwordEncoder().encode("123"))
                .roles("USER","ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }
    
    @Bean
    PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
