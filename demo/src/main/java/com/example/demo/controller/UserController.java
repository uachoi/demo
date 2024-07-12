package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;




@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService UserService;

    @PostMapping("/register")
    public ResponseEntity<Void> saveUser(@RequestBody User User) {
        UserService.saveUser(User);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/register")
    public ResponseEntity<List<User>> getAllTestEntities() {
        List<User> result = UserService.getAllTestEntities();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    

    @GetMapping("/hello")
    public ResponseEntity<Object> testApi() {
        String result = "API 통신에 성공하였습니다22.";
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 모든 사용자 정보를 가져오는 엔드포인트
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // 특정 사용자의 정보를 가져오는 엔드포인트
    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
    }
}