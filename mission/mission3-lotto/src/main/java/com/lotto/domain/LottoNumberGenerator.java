package com.lotto.domain;

import com.lotto.common.LottoConfig;

public class LottoNumberGenerator implements RandomNumberGenerator {

    public int getRandomNumber() {
        return (int) (Math.random() * LottoConfig.MAX_LOTTO_NUMBER) + LottoConfig.MIN_LOTTO_NUMBER;
    }

}
