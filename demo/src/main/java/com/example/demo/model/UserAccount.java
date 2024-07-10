package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id; 
import jakarta.persistence.ManyToOne;
import lombok.Getter; 
import lombok.Setter;

import java.time.LocalDateTime;
import jakarta.persistence.Table;

@Getter 
@Setter 
@Entity
@Table(name="user_account")
public class UserAccount { 
    @Id     // PK 
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INC
    @Column(name="accountid")
    private Integer accountID;

    //@Column(nullable = false, unique = true)
    private String accountNum;

    //@Column(nullable = false)
    private String accountPW;

    @ManyToOne 
    private User user;

    //@Column
    private Integer balance;

    public UserAccount(){

    }
    public UserAccount(String accountNum, String accountPW, User user, Integer balance) {
        this.accountNum = accountNum;
        this.accountPW = accountPW;
        this.user = user;
        this.balance = balance;
    }
    
}