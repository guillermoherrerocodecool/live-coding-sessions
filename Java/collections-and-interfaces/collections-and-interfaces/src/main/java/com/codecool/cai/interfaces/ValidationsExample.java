package com.codecool.cai.interfaces;

import com.codecool.cai.Example;

import java.util.ArrayList;
import java.util.List;

public class ValidationsExample implements Example {
    @Override
    public void show() {
        List<Validator> validators = new ArrayList();
        validators.add(new AtSymbolValidator());
        validators.add(new ContainsDotInDomainValidator());
        validators.add(new EndsInDotComValidator());
        EmailValidator validator = new EmailValidator(validators);
        String email = "el.@a.co";
        boolean valid = validator.isValid(email);
        System.out.println("email = " + email);
        System.out.println("valid = " + valid);
    }
}
