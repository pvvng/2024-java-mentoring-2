package com.lotto.common.exception;

public class InvalidTicketLength extends RuntimeException {
    public InvalidTicketLength(String message) {
        super(message);
    }
}
