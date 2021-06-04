package com.banking.transcation.service;

import com.banking.transcation.repository.TransactionHistoryRepository;
import com.banking.transcation.repository.entity.TransactionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionHistoryService {

  @Autowired
  TransactionHistoryRepository transactionHistoryRepository;

  public TransactionEntity get(int userId) {
    return transactionHistoryRepository.findById(userId).orElse(new TransactionEntity(973, "woeifef"));
  }
}
