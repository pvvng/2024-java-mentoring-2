package com.lotto.domain;

import com.lotto.domain.exception.UnderMinPriceErrorException;

public class LottoDomain {
    private final int LOTTO_TICKET_PRICE = 1000;

    public int calculateLottoTicketCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_TICKET_PRICE;
    }

    public int isUnderMinimumLottoPrice(int num) {
        if (num < LOTTO_TICKET_PRICE) {
            throw new UnderMinPriceErrorException(ErrorMessage.MIN_PRICE_ERROR.getMessage());
        }

        return num;
    }

}
