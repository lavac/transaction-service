package com.banking.transcation.controller;

import com.banking.transcation.repository.entity.TransactionEntity;
import com.banking.transcation.service.TransactionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionHistoryController {

  @Autowired
  TransactionHistoryService transactionHistoryService;

  @GetMapping("/")
  TransactionEntity get(@RequestParam int userId) {
     return transactionHistoryService.get(userId);
  }
}
