package com.daltonkyemiller.daltonkyemillerapi.user;

import com.daltonkyemiller.daltonkyemillerapi.user.model.User;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository testUserRepository;


    @Test
    void itShouldFindUserByUsernameEquals() {
        User testUser = new User("username","password");
        testUserRepository.save(testUser);

        Optional<User> foundUser = testUserRepository.findUserByUsernameEquals("username");
        assertFalse(foundUser.isEmpty());
    }
}