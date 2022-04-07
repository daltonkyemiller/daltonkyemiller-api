package com.daltonkyemiller.daltonkyemillerapi.user;

import com.daltonkyemiller.daltonkyemillerapi.user.model.User;
import com.mongodb.MongoWriteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('user:read')")
    public ResponseEntity<List<User>> fetchAllUsers(){
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @GetMapping("{username}")
    @PreAuthorize("hasAuthority('user:read')")
    public ResponseEntity<UserDetails> fetchUserByUsername(@PathVariable("username") String username){
        return ResponseEntity.ok().body(userService.loadUserByUsername(username));
    }

    @PostMapping("add")
    @PreAuthorize("hasAuthority('user:write')")
    public ResponseEntity<User> addUser(@Validated @RequestBody User user) throws MongoWriteException {
        return ResponseEntity.ok().body(userService.addUser(user));
    }
}
