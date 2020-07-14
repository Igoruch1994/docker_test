package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    private final UserRepository userRepository;

    public HelloController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/hello")
    public String seyHi() {
        return "Hi! How are you?";
    }

    @GetMapping("/")
    public List<User> all() {
        return userRepository.findAll();
    }

    @GetMapping("/create")
    public List<User> users() {
        User user = new User();
        user.setName("Sam");
        user.setSalary(33);
        user.setTeamName("Development");
        userRepository.save(user);
        return userRepository.findAll();
    }

}
