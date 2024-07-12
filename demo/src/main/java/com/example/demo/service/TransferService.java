package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class TransferService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private TransferRepository transferRepository;

    public Optional<UserAccount> getUserAccountNumber(String accountNumber){
        return userAccountRepository.findByAccountNumber(accountNumber);
    }
    // 이체 동작 처리
    public Transfer transferMoney(Long userId, String accountNumber, Long amount) throws Exception{
        UserAccount userAccount = userAccountRepository.findByUserId(userId).orElseThrow(() -> new Exception("User not found"));

        if(userAccount.getBalance()<amount){    // 원하는 이체 금액이 잔액보다 큰 경우
            throw new Exception("Insufficient balance");
        }

        // 내 계좌(이체하는 사람)에서 이체 금액만큼 빠짐
        userAccount.setBalance(userAccount.getBalance()-amount);
        userAccountRepository.save(userAccount); // 이체 후 잔액을 저장



        // 받는 사람 계좌 조회
        UserAccount receiverAccount = userAccountRepository.findByAccountNumber(accountNumber)
            .orElseThrow(() -> new Exception("Receiver not found"));

        // 받는 사람 계좌에 이체 금액 추가 (+amount)
        receiverAccount.setBalance(receiverAccount.getBalance() + amount);
        userAccountRepository.save(receiverAccount); // 이체 후 잔액을 저장




        // 이체 내역을 tranfer 모델에 저장
        Transfer transfer =new Transfer();
        transfer.setUserId(userId);
        transfer.setAccountNumber(accountNumber);
        transfer.setAmount(amount);

        return transferRepository.save(transfer);

    }

    public void saveTransfer(Transfer transfer) {
        throw new UnsupportedOperationException("Unimplemented method 'saveTransfer'");
    }
    
}
