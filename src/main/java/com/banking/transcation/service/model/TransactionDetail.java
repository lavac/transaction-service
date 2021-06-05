package com.banking.transcation.service.model;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDetail {
  @NonNull
  private String userId;

  @NonNull
  private String counterPartyId;
  private String counterPartyName;

  @NonNull
  private TransactionType type;

  @NonNull
  private TransactionStatus status;
  private String description;

  @NonNull
  private long amount;

  @NonNull
  private String currency;

  @NonNull
  private long updatedBalance;

  @NonNull
  private LocalDateTime dateTime;
}
