package com.elitekaycy.blogapi.blog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.elitekaycy.blogapi.blog.Repository.UserRepository;
import com.elitekaycy.blogapi.blog.models.Users;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> getAllUsers() {
        Iterable<Users> users = userRepository.findAll();
        List<Users> userList = StreamSupport.stream(users.spliterator(), false).collect(Collectors.toList());
        return userList;
    }

    public Users saveUser(Users myUser) {
        Users newUser = userRepository.save(myUser);
        return newUser;
    }

    public Users getSpecificUser(Long id) {
        Users specificUser = userRepository.findById(id).orElse(null);
        return specificUser;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
