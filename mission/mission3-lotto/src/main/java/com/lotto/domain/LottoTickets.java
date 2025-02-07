package com.lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoTickets {

    private final List<LottoTicket> tickets;

    public LottoTickets(List<LottoTicket> tickets) {
        this.tickets = Collections.unmodifiableList(tickets);
    }

    public List<LottoTicket> getTickets() {
        return tickets;
    }

}
