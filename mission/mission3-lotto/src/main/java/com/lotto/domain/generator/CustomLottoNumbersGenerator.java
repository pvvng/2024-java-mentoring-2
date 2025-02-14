package com.lotto.domain.generator;

import com.lotto.common.ErrorMessage;
import com.lotto.common.exception.NaNException;
import com.lotto.domain.model.LottoNumber;

import java.util.Arrays;
import java.util.List;

public class CustomLottoNumbersGenerator implements LottoNumbersGenerator {

    private static final String SPLIT_REGEX = "\\s*,\\s*";
    private final String stringNumbers;

    private CustomLottoNumbersGenerator(String stringNumbers) {
        this.stringNumbers = stringNumbers;
    }

    public static LottoNumbersGenerator create(String input) {
        return new CustomLottoNumbersGenerator(input);
    }

    @Override
    public List<LottoNumber> getNumbers() {
        return Arrays.stream(stringNumbers.split(SPLIT_REGEX))
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
