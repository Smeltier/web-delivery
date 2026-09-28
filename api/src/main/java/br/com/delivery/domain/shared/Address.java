package br.com.delivery.domain.shared;

import br.com.delivery.domain.exception.InvalidAddressException;;

public record Address(
    String country,
    String state,
    String city,
    String street,
    String complement,
    int number,
    ZipCode zipCode
) {
    public Address {
        if (country == null || country.isBlank()) {
            throw new InvalidAddressException("Country name cannot be null or blank");
        }

        if (city == null || city.isBlank()) {
            throw new InvalidAddressException("City name cannot be null or blank");
        }

        if (state == null || state.isBlank()) {
            throw new InvalidAddressException("State name cannot be null or blank");
        }

        if (street == null || street.isBlank()) {
            throw new InvalidAddressException("Street name cannot be null or blank");
        }

        if (complement != null && complement.isBlank()) {
            throw new InvalidAddressException("Complement cannot be blank");
        }

        if (number <= 0) {
            throw new InvalidAddressException("Number cannot be less or equal to zero");
        }

        if (zipCode == null) {
            throw new InvalidAddressException("Zip Code cannot be null");
        }
    }
}
