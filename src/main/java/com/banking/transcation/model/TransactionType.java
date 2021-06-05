package com.banking.transcation.model;

import com.banking.transcation.exception.UnknownTransactionTypeException;

public enum TransactionType {
  CREDIT,
  DEBIT;

  public static String getValueInString(TransactionType type) {
    try {
      return  (type == null) ? null : type.toString();
    } catch (Exception ex) {
      String msg = String.format("No TransactionType found with type=%s and allowed values are: %s and %s",
          type, CREDIT.toString(), DEBIT.toString());
      throw new UnknownTransactionTypeException(msg);
    }
  }
}
