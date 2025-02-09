package com.lotto.common;

public enum LottoConfig {

    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    LOTTO_PRICE(1000),
    LOTTO_TICKET_LENGTH(6);

    private final int config;

    LottoConfig(int config) {
        this.config = config;
    }

    public int getConfig() {
        return config;
    }

}
