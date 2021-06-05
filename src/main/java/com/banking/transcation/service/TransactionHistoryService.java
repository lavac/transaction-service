package com.banking.transcation.service;

import com.banking.transcation.exception.NoTransactionFoundException;
import com.banking.transcation.repository.entity.TransactionDetailEntity;
import com.banking.transcation.model.DateRange;
import com.banking.transcation.repository.TransactionHistoryRepository;
import com.banking.transcation.model.TransactionDetail;
import com.banking.transcation.model.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransactionHistoryService {

  @Autowired
  TransactionHistoryRepository transactionHistoryRepository;

  @Autowired
  TransactionDetailModelMapper transactionDetailModelMapper;

  public List<TransactionDetail> get(String userId, TransactionType type, Optional<DateRange> dateRange) {

    List<TransactionDetailEntity> transactionDetails;

    if (dateRange.isPresent()) {
      transactionDetails = transactionHistoryRepository
          .findByUserIdAndOptionalFilters(userId,
              dateRange.get().getStartDate(),
              dateRange.get().getEndDate(),
              TransactionType.getValueInString(type));
    } else {
      transactionDetails = transactionHistoryRepository
          .findByUserIdAndOptionalTypeFilter(userId,
              TransactionType.getValueInString(type));
    }
    return transactionDetails
        .stream()
        .map(transactionDetailEntity ->
            transactionDetailModelMapper.map(transactionDetailEntity))
        .collect(Collectors.toList());
  }

  public TransactionDetail findById(String id) {
    TransactionDetailEntity transactionDetailEntity = transactionHistoryRepository.findById(id)
        .orElseThrow(() -> new NoTransactionFoundException("Transaction is not found for given transaction id"));
    return transactionDetailModelMapper.map(transactionDetailEntity);
  }
}
