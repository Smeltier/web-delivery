package br.com.delivery.domain.restaurant;

import java.time.LocalTime;

import br.com.delivery.domain.exception.InvalidBusinessHoursException;

public record BusinessHours(LocalTime open, LocalTime close) {
    public BusinessHours {
        if (open == null || close == null) {
            throw new InvalidBusinessHoursException("Opening or closing time cannot be null");
        }

        if (close.isBefore(open)) {
            throw new InvalidBusinessHoursException("Closing time cannot come before opening time");
        }
    }

    public boolean isWithin(LocalTime time) {
        return !time.isBefore(open) && !time.isAfter(close);
    }
}
