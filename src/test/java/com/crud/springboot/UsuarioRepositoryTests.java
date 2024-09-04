package com.crud.springboot;

import com.crud.springboot.Entities.Role;
import com.crud.springboot.Entities.User;
import com.crud.springboot.Repositories.RolRepository;
import com.crud.springboot.Repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UsuarioRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser() {
        Role rolAdmin = new Role("ADMIN");
        entityManager.persist(rolAdmin);
    }
    @Test
    public void testCrearRolUsuario() {

        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");

        userRepository.save(user);
    }



}
