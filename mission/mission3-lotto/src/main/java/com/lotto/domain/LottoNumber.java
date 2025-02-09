package com.lotto.domain;

import com.lotto.common.ErrorMessage;
import com.lotto.common.LottoConfig;
import com.lotto.common.exception.InvalidLottoNumberException;

public record LottoNumber(int lottoNumber) {

    public LottoNumber {
        validateLottoNumber(lottoNumber);
    }

    private void validateLottoNumber(int lottoNumber) {
        if (lottoNumber < LottoConfig.MIN_LOTTO_NUMBER.getConfig() || lottoNumber > LottoConfig.MAX_LOTTO_NUMBER.getConfig()) {
            throw new InvalidLottoNumberException(ErrorMessage.INVALID_LOTTO_NUMBER_ERROR.getMessage());
        }
    }

}
