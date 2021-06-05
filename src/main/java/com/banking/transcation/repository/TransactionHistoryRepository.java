package com.banking.transcation.repository;

import com.banking.transcation.repository.entity.TransactionDetailEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionHistoryRepository  extends CrudRepository<TransactionDetailEntity, String> {

  @Query("from transaction_detail where user_id = :userId and "
      + "(:startDateTime is null or date_time >= :startDateTime) and "
      + "(:endDateTime is null or date_time <= :endDateTime) and "
      + "(:type is null or type = :type)"
  )
  List<TransactionDetailEntity> findByUserIdAndOptionalFilters(
      @Param("userId") String userId,
      @Param("startDateTime") long startDateTime,
      @Param("endDateTime") long endDateTime,
      @Param("type") String type
  );
}
