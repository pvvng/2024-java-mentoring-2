package com.lotto.domain;

import com.lotto.common.LottoConfig;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AutoLottoNumbersGenerator {

    private final List<LottoNumber> numbers;

    private AutoLottoNumbersGenerator() {
        this.numbers = createRandomLottoNumbers();
    }

    public static List<LottoNumber> getNumbers() {
        return new AutoLottoNumbersGenerator().numbers;
    }

    private List<LottoNumber> createRandomLottoNumbers() {
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
