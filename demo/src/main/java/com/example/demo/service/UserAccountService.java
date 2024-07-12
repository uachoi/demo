package com.example.demo.service;

import com.example.demo.model.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserAccountService {

    private final UserAccountRepository userAccountRepository;

    public UserAccount createAccount(Long userId, UserAccount userAccount) {
        // Add any additional business logic here if needed
        return userAccountRepository.save(userAccount);
    }
}