package com.lotto.common.exception;

import com.lotto.common.ErrorMessage;

public class MinLottoPriceException extends RuntimeException {
    public MinLottoPriceException(String message) {
        super(message);
    }
}
