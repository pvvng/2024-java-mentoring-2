package com.lotto.domain.exception;

public class UnderMinPriceErrorException extends RuntimeException {
    public UnderMinPriceErrorException(String message) {
        super(message);
    }
}