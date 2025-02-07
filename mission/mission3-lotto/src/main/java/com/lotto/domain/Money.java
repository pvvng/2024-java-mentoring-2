package com.lotto.domain;

import com.lotto.common.ErrorMessage;
import com.lotto.common.exception.MinLottoPriceException;

public class Money {

    private final int LOTTO_PRICE = 1000;
    private final int purchaseAmount;

    public Money(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public int getLottoTicketAmount() {
        return purchaseAmount / LOTTO_PRICE;
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE) {
            throw new MinLottoPriceException(ErrorMessage.MIN_PRICE_ERROR.getMessage());
        }
    }

}
