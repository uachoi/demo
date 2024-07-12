package com.example.demo.controller;

import com.example.demo.model.Transfer;
import com.example.demo.model.UserAccount;
import com.example.demo.service.TransferService;
import com.example.demo.repository.UserAccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
@CrossOrigin(origins = "http://localhost:5137")
public class TransferController {
    
    @Autowired
    private TransferService transferService;

    @Autowired
    private UserAccountRepository userAccountRepository;

    // 특정 사용자의 정보를 가져오는 엔드포인트
    @GetMapping("/info/{userid}")
    public ResponseEntity<UserAccount> getByUserId(@PathVariable Long userid) {
        UserAccount userAccount = userAccountRepository.findByUserId(userid)
            .orElseThrow(() -> new RuntimeException("User not found with id: " + userid));
        return ResponseEntity.ok(userAccount);
    }

    @PostMapping("/transfer")
    public ResponseEntity<Transfer> transferMoney(@RequestBody TransferRequest transferRequest) {
        try {
            Transfer transfer = transferService.transferMoney(
                transferRequest.getUserId(),
                transferRequest.getAccountNumber(),
                transferRequest.getAmount()
            );
            return new ResponseEntity<>(transfer, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}

class TransferRequest {
    private Long userId;
    private String accountNumber;
    private Long amount;

    // Getter and Setter methods
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}