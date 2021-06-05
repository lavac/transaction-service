package com.banking.transcation.service;

import com.banking.transcation.repository.entity.TransactionDetailEntity;
import com.banking.transcation.model.TransactionDetail;
import com.banking.transcation.model.TransactionStatus;
import com.banking.transcation.model.TransactionType;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Component
public class TransactionDetailModelMapper {

  public TransactionDetail map(TransactionDetailEntity entity) {
    return TransactionDetail.builder()
        .userId(entity.getUserId())
        .counterPartyId(entity.getCounterPartyId())
        .counterPartyName(entity.getCounterPartyName())
        .amount(entity.getAmount())
        .description(entity.getDescription())
        .currency(entity.getCurrency())
        .dateTime(LocalDateTime.ofEpochSecond(entity.getDateTime(), 0, ZoneOffset.UTC))
        .status(TransactionStatus.valueOf(entity.getStatus()))
        .type(TransactionType.valueOf(entity.getType()))
        .updatedBalance(entity.getUpdatedBalance())
        .build();
  }
}
