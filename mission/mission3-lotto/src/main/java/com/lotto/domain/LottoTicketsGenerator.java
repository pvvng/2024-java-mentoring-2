package com.lotto.domain;

import com.lotto.common.LottoConfig;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoTicketsGenerator {

    private final RandomNumberGenerator lottoNumberGenerator;

    public LottoTicketsGenerator(RandomNumberGenerator numberGenerator) {
        this.lottoNumberGenerator = numberGenerator;
    }

    public LottoTickets getLottoTickets(Money purchaseMoney) {
        int purchaseAmount = purchaseMoney.getLottoTicketAmount();

        return new LottoTickets(createLottoTicketList(purchaseAmount));
    }

    private List<LottoTicket> createLottoTicketList(int purchaseAmount) {
        List<LottoTicket> tickets = new ArrayList<>();

        for (int i = 0; i < purchaseAmount; i++) {
            tickets.add(getLottoTicket());
        }

        return tickets;
    }

    private LottoTicket getLottoTicket() {
        return new LottoTicket(createLottoNumbers());
    }

    private List<LottoNumber> createLottoNumbers() {
        Set<LottoNumber> ticket = new HashSet<>();

        while (ticket.size() < LottoConfig.LOTTO_TICKET_LENGTH) {
            ticket.add(getLottoNumber());
        }

        return ticket.stream().toList();
    }

    private LottoNumber getLottoNumber() {
        return new LottoNumber(lottoNumberGenerator.getRandomNumber());
    }

}
