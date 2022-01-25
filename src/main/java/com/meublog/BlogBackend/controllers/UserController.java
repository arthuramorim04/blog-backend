package com.meublog.BlogBackend.controllers;

import com.meublog.BlogBackend.entities.User;
import com.meublog.BlogBackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user.getUsername(), user.getPassword()));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<User>> getUserById() {
        return ResponseEntity.ok(userService.getAllUser());
    }

}
