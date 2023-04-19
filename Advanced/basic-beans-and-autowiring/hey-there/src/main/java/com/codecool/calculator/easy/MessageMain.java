package com.codecool.calculator.easy;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MessageMain implements ApplicationRunner {
    
    private final HeyThere heyThere;
    
    public MessageMain(HeyThere heyThere) {
        this.heyThere = heyThere;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String message = heyThere.message();
        System.out.println(message);
    }
}
