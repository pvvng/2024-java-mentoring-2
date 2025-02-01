package com.lotto.domain;

import com.lotto.domain.exception.NaNErrorException;
import com.lotto.domain.exception.NotIntegerException;

public class IntegerParser {
    public int parseInteger(String str) {
        try {
            return isInteger(str);
        } catch (NumberFormatException e) {
            throw new NaNErrorException(ErrorMessage.NAN_ERROR.getMessage());
        }
    }

    private int isInteger(String str) {
        double doubleStr = Double.parseDouble(str);

        if (doubleStr != (int) doubleStr) {
            throw new NotIntegerException(ErrorMessage.NOT_INTEGER_ERROR.getMessage());
        }

        return (int) doubleStr;
    }
}