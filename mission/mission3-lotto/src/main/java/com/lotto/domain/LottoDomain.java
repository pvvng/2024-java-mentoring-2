package com.lotto.domain;

import com.lotto.domain.exception.UnderMinPriceErrorException;

import java.util.ArrayList;
import java.util.List;

public class LottoDomain {
    private final int LOTTO_TICKET_PRICE = 1000;
    private final int LOTTO_TICKET_LENGTH = 6;

    public int calculateLottoTicketCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_TICKET_PRICE;
    }

    public int isUnderMinimumLottoPrice(int num) {
        if (num < LOTTO_TICKET_PRICE) {
            throw new UnderMinPriceErrorException(ErrorMessage.MIN_PRICE_ERROR.getMessage());
        }

        return num;
    }

    public LottoTicket buildLottoTicket(LottoNumberGenerator lottoNumberGenerator) {
        List<Integer> lottoNumbers = new ArrayList<>();

        for (int i = 0; i < LOTTO_TICKET_LENGTH; i++) {
            lottoNumbers.add(lottoNumberGenerator.getRandomNumber());
        }

        return new LottoTicket(lottoNumbers);
    }

}
