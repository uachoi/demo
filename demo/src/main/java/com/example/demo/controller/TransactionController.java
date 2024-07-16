package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Transaction;
import com.example.demo.service.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/transaction")     // "/api/transaction/buy|sell"
@Validated
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/buy")
    public ResponseEntity<?> handleStock(@Valid @RequestBody TransactionEntity transactionEntity)throws Exception{
        Transaction transaction=transactionService.createTransaction(
            transactionEntity.getUserId(),
            transactionEntity.getStockCode(),
            transactionEntity.getPrice(),
            transactionEntity.getQuantity(),
            transactionEntity.getProductName()
            //transactionEntity.get
            );
        return ResponseEntity.status(201).body(transaction);
    }

    @PostMapping("/sell")
    public ResponseEntity<?> handleSellStock(@Valid @RequestBody TransactionEntity transactionEntity)throws Exception{
        Transaction transaction=transactionService.deleteTransaction(
            transactionEntity.getUserId(),
            transactionEntity.getStockCode(),
            transactionEntity.getPrice(),
            transactionEntity.getQuantity(),
            transactionEntity.getProductName()
            //transactionEntity.get
            );
        return ResponseEntity.status(201).body(transaction);
    }
    

    // @GetMapping("/{stockCode}")
    // public Stock getStock(@PathVariable String stockCode) throws Exception {
    //     return stockService.getStockByCode(stockCode);
    // }

    // @PostMapping("/")
    // public Stock createStock(@RequestBody Stock stock) {
    //     return stockService.saveStock(stock);
    // }
}

class TransactionEntity{
    private Long userId;
    private String stockCode;
    private Long price;
    private int quantity;
    private String productName;

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStockCode() {
        return stockCode;
    }
    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public Long getPrice() {
        return price;
    }
    public void setPrice(Long price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductName(){
        return productName;
    }
    public void setProductName(String productName){
        this.productName=productName;
    }
}