package com.example.demo.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AccountPassword;
import com.example.demo.model.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import com.example.demo.service.UserService;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/account")
public class UserAccountController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserAccountRepository accountRepository;

    @Autowired
    private UserAccountService userAccountService;

    @PostMapping("/create")
    public ResponseEntity<UserAccount> createAccount(@RequestParam("email") String email, @RequestBody AccountPassword accountPassword) {
        try {
            // 사용자 정보 조회
            User user = userRepository.findByEmail(email);
            if (user == null) {
                return ResponseEntity.notFound().build(); // 사용자가 존재하지 않으면 404 반환
            }

            // 계좌 정보 설정
            UserAccount userAccount = new UserAccount();
            userAccount.setUserId(user.getId());
            userAccount.setAccountPassword(accountPassword.getAccountPassword());
            userAccount.setAccountNumber(generateRandomAccountNumber());
            userAccount.setBalance(300000);

            // 계좌 생성 서비스 호출
            UserAccount createdAccount = userAccountService.createAccount(user.getId(), userAccount);

            return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    private String generateRandomAccountNumber() {
        Random random = new Random();
        int accountNumber = 10000000 + random.nextInt(90000000);
        return String.valueOf(accountNumber);
    }
}