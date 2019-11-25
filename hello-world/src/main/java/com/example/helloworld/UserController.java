package com.example.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users")
    public Long createUser(@RequestBody User user){
        return userRepository.save(user).getId();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id){
        return userRepository.findById(id).get();
    }

}
