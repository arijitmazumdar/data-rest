package com.spring.test.datarest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.spring.test.datarest.entity.WebsiteUser;

@Component("beforeCreateWebsiteUserValidator")
public class WebsiteUserValidator  implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return WebsiteUser.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {

        WebsiteUser user = (WebsiteUser) obj;
        System.out.println("Inside Validate");
        if (checkInputString(user.getName())) {           
            errors.rejectValue("name", "name.empty");
        }

        if (checkInputString(user.getEmail())) {
            errors.rejectValue("email", "email.empty");
        }
    }

    private boolean checkInputString(String input) {
        return (input == null || input.trim().length() == 0);
    }

}