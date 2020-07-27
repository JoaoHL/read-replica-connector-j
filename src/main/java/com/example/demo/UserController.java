package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class UserController {
    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) return  ResponseEntity.notFound().build();
        return ResponseEntity.ok(user.get());
    }

    //@Transactional(readOnly = true)
    @GetMapping("/findByName/{name}")
    public  ResponseEntity findByName(@PathVariable String name) {
        User user = userRepository.findByName(name);
        if (user == null) return  ResponseEntity.notFound().build();
        return ResponseEntity.ok(user);
    }
}
