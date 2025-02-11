package com.lotto.common;

public enum PrizeMoneyConfig {

    FIRST_PLACE_PRIZE_MONEY(2000000000),
    SECOND_PLACE_PRIZE_MONEY(30000000),
    THIRD_PLACE_PRIZE_MONEY(1500000),
    FOURTH_PLACE_PRIZE_MONEY(50000),
    FIFTH_PLACE_PRIZE_MONEY(5000);

    private final int prizeMoney;

    PrizeMoneyConfig(int prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

}
