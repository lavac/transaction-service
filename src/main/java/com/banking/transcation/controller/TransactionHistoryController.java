package com.banking.transcation.controller;

import com.banking.transcation.service.model.DateRange;
import com.banking.transcation.service.TransactionHistoryService;
import com.banking.transcation.service.model.TransactionDetail;
import com.banking.transcation.service.model.TransactionType;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Validated
@RequestMapping("transactionHistory")
@RestController
public class TransactionHistoryController {

  @Autowired
  TransactionHistoryService transactionHistoryService;

  @GetMapping(value = "/", produces = "application/json")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Returns Transaction history for the given userId and for appropriate filters"),
      @ApiResponse(code = 400, message = "Invalid request parameters"),
      @ApiResponse(code = 404, message = "user not found"),
      @ApiResponse(code = 500, message = "Internal Server Error")
  })
  ResponseEntity<List<TransactionDetail>> get(
      @Valid
      @NotBlank(message = "userId cannot be null/empty")
      @Size(max = 256, message = "userId must be not more than 256 characters long")
      @RequestParam("userId") String userId,
      @RequestParam(name = "transactionType", required = false) TransactionType transactionType,
      @RequestParam(name = "startDateTime", required = false) String startDateTime,
      @RequestParam(name = "endDateTime", required = false) String endDateTime
  ) {

    DateRange dateRange = DateRange.validateAndGetDateRange(startDateTime, endDateTime);

    List<TransactionDetail> transactionDetails = transactionHistoryService.get(userId, transactionType, dateRange);
    return ResponseEntity.status(HttpStatus.OK).body(transactionDetails);
  }
}
