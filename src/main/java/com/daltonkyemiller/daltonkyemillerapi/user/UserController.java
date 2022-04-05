package com.daltonkyemiller.daltonkyemillerapi.user;

import com.daltonkyemiller.daltonkyemillerapi.project.ProjectService;
import com.daltonkyemiller.daltonkyemillerapi.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
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
}
