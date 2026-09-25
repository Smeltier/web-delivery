package br.com.delivery.domain.exception;

public final class InvalidMenuItemException extends RuntimeException {
    public InvalidMenuItemException(String message) {
        super(message);
    }
}
