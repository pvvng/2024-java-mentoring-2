package com.lotto.domain;

import com.lotto.domain.vo.Money;
import com.lotto.domain.vo.LottoTickets;
import com.lotto.domain.model.Ticket;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketsGenerator {

    public LottoTickets getLottoTickets(Money purchaseMoney) {
        int purchaseAmount = purchaseMoney.getLottoTicketAmount();

        return new LottoTickets(createLottoTicketList(purchaseAmount));
    }

    private List<Ticket> createLottoTicketList(int purchaseAmount) {
        List<Ticket> tickets = new ArrayList<>();

        for (int i = 0; i < purchaseAmount; i++) {
            tickets.add(getLottoTicket());
        }

        return tickets;
    }

    private Ticket getLottoTicket() {
        return Ticket.builder()
                .withRandomNumbers()
                .build();
    }

}
