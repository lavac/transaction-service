package com.banking.transcation.exception;

public class NoTransactionFoundException extends RuntimeException{
  public NoTransactionFoundException(String id) {
    super(id);
  }
}
