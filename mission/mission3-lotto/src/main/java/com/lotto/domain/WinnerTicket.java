package com.lotto.domain;

import java.util.List;

public record WinnerTicket(List<LottoNumber> winnerTicket) implements Ticket {

    public WinnerTicket {
        validateTicketLength(winnerTicket);
    }

    public List<LottoNumber> getTicket() {
        return winnerTicket;
    }
}
