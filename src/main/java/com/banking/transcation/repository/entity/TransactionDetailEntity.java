package com.banking.transcation.repository.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity(name = "transaction_detail")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDetailEntity {
  @Id
  private String id;

  @NonNull
  @Column(name = "user_id")
  private String userId;

  @NonNull
  @Column(name = "counter_party_id")
  private String counterPartyId;

  @Column(name = "counter_party_name")
  private String counterPartyName;

  @NonNull
  @Column(name = "type")
  private String type;

  @NonNull
  @Column(name = "status")
  private String status;

  @Column(name = "description")
  private String description;

  @NonNull
  @Column(name = "amount")
  private long amount;

  @NonNull
  @Column(name = "currency")
  private String currency;

  @NonNull
  @Column(name = "updatedBalance")
  private long updatedBalance;

  @NonNull
  @Column(name = "dateTime")
  private Timestamp dateTime;
}
