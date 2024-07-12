package com.example.demo.controller;

import com.example.demo.model.UserAccount;
import com.example.demo.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/transfer")
@CrossOrigin(origins = "http://localhost:5137")
public class TransferPwController {

    @Autowired
    private TransferService transferService;

    @PostMapping("/verifypassword")
    public ResponseEntity<PasswordVerificationResponse> verifyPassword(@RequestBody PasswordVerificationRequest request) {
        try {
            boolean passwordCorrect = transferService.verifyPassword(
                    request.getUserId(),
                    request.getAccountPassword()
            );
            return ResponseEntity.ok(new PasswordVerificationResponse(passwordCorrect));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    static class PasswordVerificationRequest {
        private Long userId;
        private String accountPassword;

        // Getter and Setter methods
        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public String getAccountPassword() {
            return accountPassword;
        }

        public void setAccountPassword(String accountPassword) {
            this.accountPassword = accountPassword;
        }
    }

    static class PasswordVerificationResponse {
        private boolean success;

        public PasswordVerificationResponse(boolean success) {
            this.success = success;
        }

        // Getter method
        public boolean isSuccess() {
            return success;
        }

        // Setter method (not needed for this response)
    }
    
}
