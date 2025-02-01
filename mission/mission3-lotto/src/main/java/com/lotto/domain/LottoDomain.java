package com.lotto.domain;

import com.lotto.domain.exception.UnderMinPriceErrorException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoDomain {
    private final int LOTTO_TICKET_PRICE = 1000;
    private final int LOTTO_TICKET_LENGTH = 6;

    public int calculateLottoTicketCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_TICKET_PRICE;
    }

    public int isUnderMinimumLottoPrice(int num) {
        if (num < LOTTO_TICKET_PRICE) {
            throw new UnderMinPriceErrorException(ErrorMessage.MIN_PRICE_ERROR.getMessage());
        }

        return num;
    }

    public String getFormattedLottoTickets(LottoTickets lottoTickets){
        StringBuilder formatedTickets = new StringBuilder();

        for(LottoTicket lottoTicket : lottoTickets.lottoTickets()){
            formatedTickets.append(lottoTicket.lottoNumbers()).append("\n");
        }

        return formatedTickets.toString();
    }

    public LottoTickets getLottoTickets(LottoNumberGenerator lottoNumberGenerator, int lottoTicketCount) {
        List<LottoTicket> lottoTickets = new ArrayList<>();

        for (int i = 0; i < lottoTicketCount; i++) {
            LottoTicket lottoTicket = buildLottoTicket(lottoNumberGenerator);
            lottoTickets.add(lottoTicket);
        }

        return new LottoTickets(lottoTickets);
    }

    private LottoTicket buildLottoTicket(LottoNumberGenerator lottoNumberGenerator) {
        Set<Integer> lottoNumbers = new HashSet<>();

        while(lottoNumbers.size() != LOTTO_TICKET_LENGTH){
            lottoNumbers.add(lottoNumberGenerator.getRandomNumber());
        }

        return new LottoTicket(lottoNumbers);
    }
}
