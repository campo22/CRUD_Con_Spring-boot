package com.crud.springboot.Repositories;

import com.crud.springboot.Entities.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RolRepository extends CrudRepository<Role, Long> {

    Optional<Role> findByName(String name);
}
