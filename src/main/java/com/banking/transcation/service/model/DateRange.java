package com.banking.transcation.service.model;

import com.banking.transcation.exception.InvalidDateRangeException;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Builder
@Data
@NoArgsConstructor
public class DateRange {

  private long startDate;
  private long endDate;
  private static final String PATTERN = "yyyy-MM-dd HH:mm:ss";

  public DateRange(long startDateInEpoch, long endDateInEpoch) {
    this.startDate = startDateInEpoch;
    this.endDate = endDateInEpoch;
  }

  public static Optional<DateRange> validateAndGetDateRange(String startDateTime, String endDateTime) {
    if (startDateTime == null && endDateTime == null)
      return Optional.empty();

    else if (startDateTime == null || endDateTime == null) {
      throw new InvalidDateRangeException("Either startDate or endDate cannot be null (both should be passed together or"
          + " can be skipped together)");
    } else {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN);

      long startDateInEpoch = LocalDateTime.parse(startDateTime, formatter).toEpochSecond(ZoneOffset.UTC);
      long endDateInEpoch = LocalDateTime.parse(endDateTime, formatter).toEpochSecond(ZoneOffset.UTC);

      return Optional.of(new DateRange(startDateInEpoch, endDateInEpoch));
    }
  }
}
