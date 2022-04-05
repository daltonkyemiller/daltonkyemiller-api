package com.daltonkyemiller.daltonkyemillerapi.user;

import com.daltonkyemiller.daltonkyemillerapi.user.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;


import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findUserByUsernameEquals(String username);

}
