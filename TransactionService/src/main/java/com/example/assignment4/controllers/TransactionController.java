package com.example.assignment4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.assignment4.models.TransactionModel;
import com.example.assignment4.services.TransactionService;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080") 
@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public ResponseEntity<List<TransactionModel>> getAllTransactions() 
    {
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionModel> getTransaction(@PathVariable int id) 
    {
        TransactionModel transaction = transactionService.getTransaction(id);
        return transaction != null ? ResponseEntity.ok(transaction) : ResponseEntity.notFound().build();
    }

    @PostMapping("/addTransaction")
    public ResponseEntity<TransactionModel> addTransaction(@RequestBody TransactionModel transaction) 
    {
        TransactionModel newTransaction = transactionService.saveTransaction(transaction);
        return ResponseEntity.ok(newTransaction);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransactionModel> updateTransaction(@PathVariable int id, @RequestBody TransactionModel transaction) 
    {
        transaction.setTransactionId(id);
        TransactionModel updatedTransaction = transactionService.saveTransaction(transaction);
        return ResponseEntity.ok(updatedTransaction);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable int id) 
    {
        transactionService.deleteTransaction(id);
        return ResponseEntity.ok().build();
    }


}

