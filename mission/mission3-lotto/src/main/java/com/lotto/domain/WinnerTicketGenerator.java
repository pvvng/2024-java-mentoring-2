package com.lotto.domain;

import com.lotto.common.ErrorMessage;
import com.lotto.common.exception.NaNException;

import java.util.Arrays;
import java.util.List;

public class WinnerTicketGenerator {

    final String SPLIT_REGEX = "\\s*,\\s*";

    public WinnerTicket getWinnerTicket(String winnerNumber) {
        List<LottoNumber> winnerNumbers = convertWinnerString(winnerNumber);

        return buildWinnerTicket(winnerNumbers);
    }

    private List<LottoNumber> convertWinnerString(String winnerNumber) {
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

    private WinnerTicket buildWinnerTicket(List<LottoNumber> winnerNumbers) {
        return new WinnerTicket(winnerNumbers);
    }

}
