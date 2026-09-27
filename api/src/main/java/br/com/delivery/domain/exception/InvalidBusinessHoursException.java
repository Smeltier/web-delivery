package br.com.delivery.domain.exception;

public final class InvalidBusinessHoursException extends RuntimeException {
    public InvalidBusinessHoursException(String message) {
        super(message);
    }
}
