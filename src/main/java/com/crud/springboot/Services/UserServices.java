package com.crud.springboot.Services;

import com.crud.springboot.Entities.User;

import java.util.List;

public interface UserServices {

    List<User> findAll();

    User seve(User user);

    boolean existsByUsername(String username);

}
