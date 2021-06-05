package com.banking.transcation.exception;

public class UnknownTransactionTypeException extends RuntimeException {
  public UnknownTransactionTypeException(String msg) {
    super(msg);
  }
}
