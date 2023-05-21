package com.example.jpatest.repository;

import com.example.jpatest.JpatestApplication;
import com.example.jpatest.JpatestApplicationTests;
import com.example.jpatest.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserRepositoryTests extends JpatestApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){
        User user = new User();

        user.setAccount("testID123");
        user.setPassword("testPW123");
        user.setName("Onigi");

        User  newUser = userRepository.save(user);
    }

    @Test
    public void read(){
        Optional<User> user = userRepository.findById(9L);

        user.ifPresent(selectUser -> {
            System.out.println(selectUser.getName());
            System.out.println(selectUser.getAccount());
        });
    }

    @Test
    public void update(){
        Optional<User> user = userRepository.findById(1L);

        user.ifPresent(selectUser ->{
            selectUser.setName("김민수");
            selectUser.setAccount("kimmin123");
            userRepository.save(selectUser);
        });
    }
}
