package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;



/**
 * Please explain the class!!
 *
 * @author : jonghoon
 * @fileName : TestController
 * @since : 2/5/24
 */
@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/v1/test")
public class UserController {

    @Autowired
    private UserService UserService;

    // @PostMapping("/api/v2/test")
    // public void saveUser(@RequestBody User User) {
    //     System.out.println(User);
    //     UserService.saveUser(User);
    // }

    // @GetMapping("/api/v2/test")
    // public List<User> getAllTestEntities() {
    //     List result = UserService.getAllTestEntities();
    //     return new ResponseEntity<>(result, HttpStatus.OK);
    // }

    @PostMapping("/test1")
    public ResponseEntity<Void> saveUser(@RequestBody User User) {
        UserService.saveUser(User);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/test1")
    public ResponseEntity<List<User>> getAllTestEntities() {
        List<User> result = UserService.getAllTestEntities();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    

    @GetMapping("/hello")
    public ResponseEntity<Object> testApi() {
        String result = "API 통신에 성공하였습니다22.";
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}