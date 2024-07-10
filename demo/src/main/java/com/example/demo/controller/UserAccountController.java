package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.User;
import com.example.demo.model.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;

// @RequiredArgsConstructor
// @Controller
// @RequestMapping("/account")
@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/account")
public class UserAccountController {

    @Autowired
    private UserAccountService accountService;
    private UserAccountRepository accountRepository;

    @GetMapping("/list")
    public String list(Model model) {
        List<UserAccount> accountList = this.accountRepository.findAll();
        model.addAttribute("accountList", accountList);
        return "account_list";
    }

    // @GetMapping("/create")
    // public String showCreateAccountPage(@RequestParam("user_id") Long userId, Model model) {
    //     model.addAttribute("userId", userId);
    //     model.addAttribute("userAccount", new UserAccount());
    //     return "create_account";
    // }

    // @PostMapping("/create")
    // public String createAccount(@RequestParam("user_id") Long userId, @ModelAttribute UserAccount userAccount) {
    //     accountService.createAccount(userId, userAccount);
    //     return "redirect:/account/list";
    // }

    // @PostMapping("/create")
    // public ResponseEntity<List<UserAccount>> saveUserAccount(@RequestBody UserAccount UserAccount) {
    //     accountService.saveUserAccount(UserAccount);
    //     return new ResponseEntity<>(HttpStatus.CREATED);
    // }
    // @GetMapping("/register")
    // public ResponseEntity<List<UserAccount>> getAllTestEntities() {
    //     List<UserAccount> result = accountService.getAllTestEntities();
    //     return new ResponseEntity<>(result, HttpStatus.OK);
    // }

    @PostMapping("/create")
    public ResponseEntity<UserAccount> createAccount(@RequestBody UserAccount userAccount, @RequestParam Long user_id) {
        UserAccount createdAccount = accountService.createAccount(user_id, userAccount);
        accountService.saveUserAccount(userAccount);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }

    @GetMapping("/create")  //list -> create
    public ResponseEntity<List<UserAccount>> getAllAccounts() {
        List<UserAccount> result = accountService.getAllTestEntities();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
}