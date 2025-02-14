package com.lotto.domain.generator;

import com.lotto.domain.model.LottoNumber;

import java.util.List;

public interface LottoNumbersGenerator {
    List<LottoNumber> getNumbers();
}
