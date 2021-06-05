package com.banking.transcation.repository;


import com.banking.transcation.repository.entity.TransactionDetailEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionHistoryRepository  extends CrudRepository<TransactionDetailEntity, String> {

  List<TransactionDetailEntity> findByUserId(String userId);
}
