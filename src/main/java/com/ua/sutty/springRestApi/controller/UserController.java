package com.ua.sutty.springRestApi.controller;

import com.ua.sutty.springRestApi.domain.User;
import com.ua.sutty.springRestApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
public class UserController {

    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

//    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/users")
    public User saveUser(User user) {
        return userService.save(user);
    }

//    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/users/{id}")
    public User updateUserById(@PathVariable Long id, User user) {
        user.setId(id);
        return userService.save(user);
    }

//    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

//    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/users")
    public List<User> userList() {
        return userService.findAll();
    }

}
