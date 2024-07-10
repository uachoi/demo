package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

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