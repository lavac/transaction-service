package com.banking.transcation.controller;

import com.banking.transcation.service.TransactionHistoryService;
import com.banking.transcation.service.model.TransactionDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionHistoryController {

  @Autowired
  TransactionHistoryService transactionHistoryService;

  @GetMapping("/")
  List<TransactionDetail> get(@RequestParam String userId) {
    return transactionHistoryService.get(userId);
  }
}
