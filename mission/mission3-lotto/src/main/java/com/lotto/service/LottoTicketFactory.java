package com.lotto.service;

import com.lotto.domain.LottoNumberGenerator;
import com.lotto.domain.LottoTicket;

import java.util.HashSet;
import java.util.Set;

public class LottoTicketFactory {
    private final LottoNumberGenerator lottoNumberGenerator;
    private final int LOTTO_TICKET_LENGTH = 6;

    public LottoTicketFactory() {
        this.lottoNumberGenerator = new LottoNumberGenerator();
    }

    public LottoTicket getLottoTicket() {
        Set<Integer> lottoNumbers = buildLottoNumbers();

        return new LottoTicket(lottoNumbers);
    }

    private Set<Integer> buildLottoNumbers() {
        Set<Integer> lottoNumbers = new HashSet<>();

        while (lottoNumbers.size() != LOTTO_TICKET_LENGTH) {
            lottoNumbers.add(lottoNumberGenerator.getRandomNumber());
        }

        return lottoNumbers;
    }

}
