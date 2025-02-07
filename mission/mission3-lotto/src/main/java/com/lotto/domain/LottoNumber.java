package com.lotto.domain;

import com.lotto.common.ErrorMessage;
import com.lotto.common.LottoConfig;
import com.lotto.common.exception.InvalidLottoNumberException;

public class LottoNumber {

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateLottoNumber(lottoNumber);

        this.lottoNumber = lottoNumber;
    }

    public int getLottoNumber(){
        return lottoNumber;
    }

    private void validateLottoNumber(int lottoNumber) {
        if(lottoNumber < LottoConfig.MIN_LOTTO_NUMBER || lottoNumber > LottoConfig.MAX_LOTTO_NUMBER){
            throw new InvalidLottoNumberException(ErrorMessage.NOT_INTEGER_ERROR.getMessage());
        }
    }

}
