package com.crud.springboot.Repositories;

import com.crud.springboot.Entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
