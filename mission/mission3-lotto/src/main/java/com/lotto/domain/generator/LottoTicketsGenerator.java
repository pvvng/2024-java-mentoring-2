package com.lotto.domain.generator;

import com.lotto.domain.vo.Money;
import com.lotto.domain.vo.LottoTickets;
import com.lotto.domain.model.Ticket;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketsGenerator {

    public static LottoTickets generateLottoTickets(Money purchaseMoney) {
        int purchaseAmount = purchaseMoney.getLottoTicketAmount();

        return new LottoTickets(createLottoTicketList(purchaseAmount));
    }

    private static List<Ticket> createLottoTicketList(int purchaseAmount) {
        List<Ticket> tickets = new ArrayList<>();

        for (int i = 0; i < purchaseAmount; i++) {
            tickets.add(getLottoTicket());
        }

        return tickets;
    }

    private static Ticket getLottoTicket() {
        return Ticket.builder()
                .withRandomNumbers()
                .build();
    }

}