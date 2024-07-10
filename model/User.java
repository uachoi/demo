package com.example.demo.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="User")
@Entity
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    // @Column(nullable = false)
    private String userName;

    // @Column(nullable = false)
    private String email;

    // @Column(nullable = false)
    private String pw;

    // @Column(nullable = false)
    private String phoneNumber;

    @JsonProperty("created_at")
    // @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime created_at;

    @JsonProperty("updated_at")
    // @Column(name = "updated_at", nullable = false)
    private LocalDateTime updated_at;

    public User() {

    }
    public User(String userName, String email, String pw, String phoneNumber, LocalDateTime created_at, LocalDateTime updated_at) {
        this.userName = userName;
        this.email = email;
        this.pw = pw;
        this.phoneNumber = phoneNumber;
        this.created_at = created_at;
        this.updated_at = updated_at;

    }

    public Long getId() {
        return userId;
    }

    public void setId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDateTime getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdatedAt() {
        return updated_at;
    }

    public void setUpdatedAt(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }
    
}