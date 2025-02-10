package com.lotto.domain;

import java.util.List;

public record LottoTicket(List<LottoNumber> lottoTicket) implements Ticket {

    public LottoTicket {
        validateTicketLength(lottoTicket);
    }

    public List<LottoNumber> getTicket(){
        return lottoTicket;
    }

    @Override
    public String toString() {
        return lottoTicket.stream()
                .map(LottoNumber::lottoNumber)
                .toList()
                .toString();
    }

}
