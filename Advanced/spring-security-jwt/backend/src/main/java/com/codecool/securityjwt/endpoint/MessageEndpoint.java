package com.codecool.securityjwt.endpoint;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("messages")
public class MessageEndpoint {

    @GetMapping("unauthorized")
    String unauthorized() {
        return "This will never be displayed due to lack of authorization";
    }

    @GetMapping("authorized")
    String authorized() {
        return "Hello, how are you doing?";
    }

    @GetMapping("authorized/customized")
    String customized(Authentication authentication) {
        return "Hello, " + authentication.getName();
    }

}
