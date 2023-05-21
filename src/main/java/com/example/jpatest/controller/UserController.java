package com.example.jpatest.controller;


import com.example.jpatest.entity.User;
import com.example.jpatest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/index")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/join")
    public String join(@RequestBody User user){

        User newUser = userRepository.save(user);

        return "congrat";
    }

    @GetMapping("/user")
    public User findUser(@RequestParam Long id){
        Optional<User> user = userRepository.findById(id);

        return user.get();
    }

    @PutMapping("/user")
    public User changeInfo(@RequestParam Long id, @RequestBody User user){

        Optional<User> updateUser = userRepository.findById(id);
        updateUser.ifPresent(selectUser -> {
            selectUser.setName(user.getName());
            selectUser.setAccount(user.getAccount());
            selectUser.setPassword(user.getPassword());

            userRepository.save(selectUser);
        });
        return null;
    }
}
