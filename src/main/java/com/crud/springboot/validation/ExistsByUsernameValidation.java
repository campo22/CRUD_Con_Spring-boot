package com.crud.springboot.validation;

import com.crud.springboot.Services.UserServices;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExistsByUsernameValidation implements ConstraintValidator<ExistsByUsername, String> {

    @Autowired
    private UserServices services;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext Context) {

        return !services.existsByUsername(username);
    }
}
