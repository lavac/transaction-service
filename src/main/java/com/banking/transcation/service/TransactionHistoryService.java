package com.banking.transcation.service;

import com.banking.transcation.repository.TransactionHistoryRepository;
import com.banking.transcation.repository.entity.TransactionDetailEntity;
import com.banking.transcation.service.model.TransactionDetail;
import org.jetbrains.annotations.NotNull;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionHistoryService {

  @Autowired
  TransactionHistoryRepository transactionHistoryRepository;

  @Autowired
  TransactionModelMapper modelMapper;

  public List<TransactionDetail> get(String userId) {
    return transactionHistoryRepository.findByUserId(userId).stream()
        .map(transactionDetailEntity ->
    modelMapper.map(transactionDetailEntity))
        .collect(Collectors.toList());
  }
}
