package com.elitekaycy.blogapi.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elitekaycy.blogapi.blog.models.Users;
import com.elitekaycy.blogapi.blog.services.UserService;


@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @PostMapping("/")
    public Users createUser(@RequestBody Users newUser) {
        return userService.saveUser(newUser);
    }


    @GetMapping("/{userId}")
    public Users getUserById(@PathVariable Long userId) {
        return userService.getSpecificUser(userId);
    }

    @DeleteMapping("/{userId}")
    public void deleteUserById(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }



}
