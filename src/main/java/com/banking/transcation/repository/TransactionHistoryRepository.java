package com.banking.transcation.repository;


import com.banking.transcation.repository.entity.TransactionEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TransactionHistoryRepository  extends CrudRepository<TransactionEntity, Integer> {
  Optional<TransactionEntity> findById(int userId);
}
