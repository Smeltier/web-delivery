package br.com.delivery.domain.shared;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import br.com.delivery.domain.exception.InvalidZipCodeException;

public class ZipCodeTest {
    @Test
    void shouldThrowWhenCodeIsNull() {
        assertThrows(InvalidZipCodeException.class,
                () -> new ZipCode(null));
    }

    @Test
    void shouldThrowWhenCodeIsBlank() {
        assertThrows(InvalidZipCodeException.class,
                () -> new ZipCode(""));
    }

    @Test
    void shouldNormalizeTheCode() {
        var normalizedCode = "36703072";
        var zipCode = new ZipCode("36703-072");
        assertEquals(zipCode.code(), normalizedCode);
    }

    void shouldThrowIfNotMatchWithPattern() {
        assertThrows(InvalidZipCodeException.class,
                () -> new ZipCode("aaaaaaaaaaaaa"));
    }
}
