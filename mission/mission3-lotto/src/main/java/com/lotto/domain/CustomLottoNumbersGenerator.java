package com.lotto.domain;

import com.lotto.common.ErrorMessage;
import com.lotto.common.exception.NaNException;

import java.util.Arrays;
import java.util.List;

public class CustomLottoNumbersGenerator {
    private static final String SPLIT_REGEX = "\\s*,\\s*";
    private final List<LottoNumber> numbers;

    private CustomLottoNumbersGenerator(String winnerNumber) {
        this.numbers = parseNumbers(winnerNumber);
    }

    public static List<LottoNumber> getNumbers(String winnerNumber) {
        return new CustomLottoNumbersGenerator(winnerNumber).numbers;
    }

    private List<LottoNumber> parseNumbers(String winnerNumber) {
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
