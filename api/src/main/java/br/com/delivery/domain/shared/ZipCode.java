package br.com.delivery.domain.shared;

import java.util.regex.Pattern;

import br.com.delivery.domain.exception.InvalidZipCodeException;

public record ZipCode(String code) {
    private static final Pattern ZIP_PATTERN = Pattern.compile("\\d{5}-?\\d{3}");

    public ZipCode {
        if (code == null || code.isBlank()) {
            throw new InvalidZipCodeException("CEP inválido.");
        }

        code = code.trim();

        if (!ZIP_PATTERN.matcher(code).matches()) {
            throw new InvalidZipCodeException("CEP inválido.");
        }

        code = normalize(code);
    }

    private String normalize(String code) {
        return code.replace("-", "");
    }

    @Override
    public String toString() {
        return code.substring(0, 5) + "-" + code.substring(5);
    }
}
