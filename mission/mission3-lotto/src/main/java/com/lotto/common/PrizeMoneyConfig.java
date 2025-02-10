package com.lotto.common;

import com.lotto.common.exception.InvalidPrizeMoneyRangeException;

public enum PrizeMoneyConfig {

    FIFTH_PLACE_PRIZE_MONEY(5000),
    FOURTH_PLACE_PRIZE_MONEY(50000),
    THIRD_PLACE_PRIZE_MONEY(1500000),
    SECOND_PLACE_PRIZE_MONEY(30000000),
    FIRST_PLACE_PRIZE_MONEY(2000000000);

    private final int prizeMoney;

    PrizeMoneyConfig(int prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static PrizeMoneyConfig fromIndex(int index) {
        if (index < 0 || index >= values().length) {
            throw new InvalidPrizeMoneyRangeException(ErrorMessage.INVALID_PRIZE_MONEY_PLACE_ERROR.getMessage());
        }

        return values()[index];
    }

}
