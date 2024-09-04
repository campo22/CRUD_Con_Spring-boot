package com.crud.springboot.Controllers;

import com.crud.springboot.Entities.User;
import com.crud.springboot.Services.UserServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserControllers {

    @Autowired
    private UserServices userServices;

    @GetMapping
    public List<User> listar() {
        return userServices.findAll();
    }


    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody User user, BindingResult resul) {
        if (resul.hasErrors()) {
            return validation(resul);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(userServices.seve(user));
    }

    private ResponseEntity<?> validation(BindingResult resul) {
        Map<String, String> errors = new HashMap<>();
        resul.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }
}





