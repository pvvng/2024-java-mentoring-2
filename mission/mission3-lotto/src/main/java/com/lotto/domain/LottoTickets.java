package com.lotto.domain;

import java.util.Collections;
import java.util.List;

public record LottoTickets(List<LottoTicket> tickets) {

    public LottoTickets(List<LottoTicket> tickets) {
        this.tickets = Collections.unmodifiableList(tickets);
    }

}
