package br.com.delivery.domain.shared;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import br.com.delivery.domain.exception.InvalidAddressException;

public class AddressTest {
    private final String country = "country";
    private final String city = "city";
    private final String state = "state";
    private final String street = "street";
    private final String complement = "complement";
    private final int number = 1;
    private final ZipCode zipCode = new ZipCode("36703-072");

    @Test
    void shouldThrowWhenCountryNameIsNull() {
        assertThrows(InvalidAddressException.class,
                () -> new Address(null, state, city, street, complement, number, zipCode));
    }

    @Test
    void shouldThrowWhenCountryNameIsBlank() {
        assertThrows(InvalidAddressException.class,
                () -> new Address("", state, city, street, complement, number, zipCode));
    }

    @Test
    void shouldThrowWhenStateNameIsNull() {
        assertThrows(InvalidAddressException.class,
                () -> new Address(country, null, city, street, complement, number, zipCode));
    }

    @Test
    void shouldThrowWhenStateNameIsBlank() {
        assertThrows(InvalidAddressException.class,
                () -> new Address(country, "", city, street, complement, number, zipCode));
    }

    @Test
    void shouldThrowWhenCityNameIsNull() {
        assertThrows(InvalidAddressException.class,
                () -> new Address(country, state, null, street, complement, number, zipCode));
    }

    @Test
    void shouldThrowWhenCityNameIsBlank() {
        assertThrows(InvalidAddressException.class,
                () -> new Address(country, state, "", street, complement, number, zipCode));
    }

    @Test
    void shouldThrowWhenStreetNameIsNull() {
        assertThrows(InvalidAddressException.class,
                () -> new Address(country, state, city, null, complement, number, zipCode));
    }

    @Test
    void shouldThrowWhenStreetNameIsBlank() {
        assertThrows(InvalidAddressException.class,
                () -> new Address(country, state, city, "", complement, number, zipCode));
    }

    @Test
    void shouldThrowWhenComplementIsBlank() {
        assertThrows(InvalidAddressException.class,
                () -> new Address(country, state, city, street, "", number, zipCode));
    }

    @Test
    void shouldThrowWhenNumberIsNegative() {
        assertThrows(InvalidAddressException.class,
                () -> new Address(country, state, city, street, complement, -1, zipCode));
    }

    @Test
    void shouldThrowWhenNumberIsZero() {
        assertThrows(InvalidAddressException.class,
                () -> new Address(country, state, city, street, complement, 0, zipCode));
    }

    @Test
    void shouldThrowWhenZipCodeIsNull() {
        assertThrows(InvalidAddressException.class,
                () -> new Address(country, state, city, null, complement, number, null));
    }
}
