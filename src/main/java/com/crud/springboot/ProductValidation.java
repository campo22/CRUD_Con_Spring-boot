package com.crud.springboot;

import com.crud.springboot.Entities.Product;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProductValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", null, "Es requerido!");

        if (product.getDescription() == null || product.getDescription().isBlank()) {
            errors.rejectValue("description", null, "Es requerido porfavor");
        }
        if (product.getPrice() == null) {
            errors.rejectValue("price", null, "no puede ser nulo,ok");
        } else if (product.getPrice() < 500) {
            errors.rejectValue("price", null, "debe ser mayor o igual a 500");

        }

    }
}
