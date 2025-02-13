package com.lotto.domain;

import java.util.Collections;
import java.util.List;

public record LottoTickets(List<Ticket> tickets) {

    public LottoTickets(List<Ticket> tickets) {
        this.tickets = Collections.unmodifiableList(tickets);
    }

}
