package com.codecool.securityweb.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("messages")
public class MessageEndpoint {
    
    @GetMapping
    String notAuthenticated(){
        return "Hey there! - not authenticated";
    }

    @GetMapping("user")
    String user(){
        return "Hey there! - user";
    }

    @GetMapping("admin")
    String admin(){
        return "Hey there! - admin";
    }
}
