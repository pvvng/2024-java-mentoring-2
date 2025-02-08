package com.lotto.domain;

import com.lotto.common.ErrorMessage;
import com.lotto.common.LottoConfig;
import com.lotto.common.exception.MinLottoPriceException;

public class Money {

    private final int purchaseAmount;

    public Money(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);

        this.purchaseAmount = purchaseAmount;
    }

    public int getLottoTicketAmount() {
        return purchaseAmount / LottoConfig.LOTTO_PRICE.getConfig();
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < LottoConfig.LOTTO_PRICE.getConfig()) {
            throw new MinLottoPriceException(ErrorMessage.MIN_PRICE_ERROR.getMessage());
        }
    }

}
