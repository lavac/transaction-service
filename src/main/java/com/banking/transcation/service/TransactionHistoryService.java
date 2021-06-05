package com.banking.transcation.service;

import com.banking.transcation.service.model.DateRange;
import com.banking.transcation.repository.TransactionHistoryRepository;
import com.banking.transcation.service.model.TransactionDetail;
import com.banking.transcation.service.model.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionHistoryService {

  @Autowired
  TransactionHistoryRepository transactionHistoryRepository;

  @Autowired
  TransactionDetailModelMapper transactionDetailModelMapper;

  public List<TransactionDetail> get(String userId, TransactionType type, DateRange dateRange) {
    return transactionHistoryRepository
        .findByUserIdAndOptionalFilters(userId,
            dateRange.getStartDate(),
            dateRange.getEndDate(),
            TransactionType.getValueInString(type))
        .stream()
        .map(transactionDetailEntity ->
            transactionDetailModelMapper.map(transactionDetailEntity))
        .collect(Collectors.toList());
  }
}
