package com.banking.transcation.controller.exceptionhandler;

import com.banking.transcation.controller.dto.ErrorResponse;
import com.banking.transcation.exception.InvalidDateRangeException;
import com.banking.transcation.exception.NoTransactionFoundException;
import com.banking.transcation.exception.UnknownTransactionTypeException;
import lombok.extern.slf4j.Slf4j;
import net.logstash.logback.encoder.org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import javax.validation.ConstraintViolationException;

import java.time.format.DateTimeParseException;

import static org.springframework.http.HttpStatus.*;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<ErrorResponse> handle(ConstraintViolationException e) {
    String rootCauseMessage = ExceptionUtils.getRootCauseMessage(e);
    log.error(String.format("UserId is null or not in valid format: %s ", rootCauseMessage));
    return ResponseEntity.status(BAD_REQUEST)
        .body(new ErrorResponse("Input parameters are not in valid format", rootCauseMessage));
  }

  @ExceptionHandler(DateTimeParseException.class)
  public ResponseEntity<ErrorResponse> handle(DateTimeParseException e) {
    String rootCauseMessage = ExceptionUtils.getRootCauseMessage(e);
    log.error(String.format("Bad Request: %s ", rootCauseMessage));
    return ResponseEntity.status(BAD_REQUEST)
        .body(new ErrorResponse("Dates should be in yyyy-MM-dd HH:mm:ss format", rootCauseMessage));
  }

  @ExceptionHandler(InvalidDateRangeException.class)
  public ResponseEntity<ErrorResponse> handle(InvalidDateRangeException e) {
    String rootCauseMessage = ExceptionUtils.getRootCauseMessage(e);
    log.error(String.format("Bad Request: %s ", rootCauseMessage));
    return ResponseEntity.status(BAD_REQUEST)
        .body(new ErrorResponse("Invalid Dates", e.getMessage()));
  }

  @ExceptionHandler(UnknownTransactionTypeException.class)
  public ResponseEntity<ErrorResponse> handle(UnknownTransactionTypeException e) {
    String rootCauseMessage = ExceptionUtils.getRootCauseMessage(e);
    log.error(String.format("Unknown Transaction type: %s ", rootCauseMessage));
    return ResponseEntity.status(BAD_REQUEST)
        .body(new ErrorResponse("Unknown Transaction type", e.getMessage()));
  }


  @ExceptionHandler(DataAccessException.class)
  public ResponseEntity<ErrorResponse> handle(DataAccessException e) {
    String rootCauseMessage = ExceptionUtils.getRootCauseMessage(e);
    log.error(String.format("Postgres exception: %s ", rootCauseMessage));
    return ResponseEntity.status(INTERNAL_SERVER_ERROR)
        .body(new ErrorResponse("Error Occurred while fetching transaction-history", rootCauseMessage));
  }

  @ExceptionHandler(NoTransactionFoundException.class)
  public ResponseEntity<ErrorResponse> handle(NoTransactionFoundException e) {
    String rootCauseMessage = ExceptionUtils.getRootCauseMessage(e);
    log.error(String.format("No transaction found: %s", rootCauseMessage));
    return ResponseEntity.status(NOT_FOUND).body(new ErrorResponse("Record not found", e.getMessage()));
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handle(Exception e) {
    String rootCauseMessage = ExceptionUtils.getRootCauseMessage(e);
    log.error(String.format("Unknown error: %s", rootCauseMessage));
    return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ErrorResponse("Unknown error", rootCauseMessage));
  }
}
