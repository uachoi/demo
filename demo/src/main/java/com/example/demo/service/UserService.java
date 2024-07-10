package com.example.demo.service;

import java.time.LocalDateTime;

import com.example.demo.repository.*;
import com.example.demo.model.*;

// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.RequiredArgsConstructor;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {
    
    @Autowired
    private UserRepository UserRepository;

    public void saveUser(User User) {
        UserRepository.save(User);
    }

    public List<User> getAllTestEntities() {
        return UserRepository.findAll();
    }
}

// @RequiredArgsConstructor
// @Service5
// public class UserService {

//     private final UserRepository userRepository;
//     private final PasswordEncoder passwordEncoder;

//     public User create(String email, String username, String phonenumber, String password) {
//         User user = new User();
//         user.setUserName(username);
//         user.setEmail(email);
//         user.setPassword(passwordEncoder.encode(password));
//     	user.setPhoneNumber(phonenumber);
// 		user.setCreatedAt(LocalDateTime.now());
// 		user.setUpdatedAt(LocalDateTime.now());
//         this.userRepository.save(user);
//         return user;
//     }
// }