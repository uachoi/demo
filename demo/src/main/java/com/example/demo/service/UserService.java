package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.model.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserAccountRepository userAccountRepository;

    public void saveUser(User User) {
        userRepository.save(User);
    }

    public List<User> getAllTestEntities() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public UserAccountRepository getUserAccountRepository() {
        return userAccountRepository;
    }

    public void setUserAccountRepository(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public UserAccount createAccount(Long userId, UserAccount userAccount) {
        userAccount.setUserId(userId);
        return userAccountRepository.save(userAccount);
    }

}