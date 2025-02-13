package com.lotto.domain;

import com.lotto.common.ErrorMessage;
import com.lotto.common.exception.NaNException;

import java.util.Arrays;
import java.util.List;

public class CustomLottoNumbersGenerator {
    final String SPLIT_REGEX = "\\s*,\\s*";

    public List<LottoNumber> getNumbers(String winnerNumber) {
        return Arrays.stream(winnerNumber.split(SPLIT_REGEX))
                .map(this::parseInt)
                .map(LottoNumber::new)
                .toList();
    }

    private int parseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new NaNException(ErrorMessage.NAN_ERROR.getMessage());
        }
    }

}
