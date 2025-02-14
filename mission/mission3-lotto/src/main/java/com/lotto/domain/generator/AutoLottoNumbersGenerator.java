package com.lotto.domain.generator;

import com.lotto.common.LottoConfig;
import com.lotto.domain.model.LottoNumber;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AutoLottoNumbersGenerator implements LottoNumbersGenerator {

    private AutoLottoNumbersGenerator() {
    }

    public static LottoNumbersGenerator create() {
        return new AutoLottoNumbersGenerator();
    }

    @Override
    public List<LottoNumber> getNumbers() {
        Set<LottoNumber> ticket = new HashSet<>();
        while (ticket.size() < LottoConfig.LOTTO_TICKET_LENGTH.getConfig()) {
            ticket.add(new LottoNumber(getRandomNumber()));
        }

        return ticket.stream().toList();
    }

    private int getRandomNumber() {
        return (int) (Math.random() * LottoConfig.MAX_LOTTO_NUMBER.getConfig()) + LottoConfig.MIN_LOTTO_NUMBER.getConfig();
    }

}
