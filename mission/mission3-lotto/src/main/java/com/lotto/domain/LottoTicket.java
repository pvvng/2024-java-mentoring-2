package com.lotto.domain;

import java.util.List;

public record LottoTicket(List<LottoNumber> lottoTicket) implements Ticket {

    public LottoTicket {
        validateTicketLength(lottoTicket);
    }

    @Override
    public String toString() {
        return lottoTicket.stream()
                .map(LottoNumber::lottoNumber)
                .toList()
                .toString();
    }

    public boolean isContain(LottoNumber number) {
        return lottoTicket.stream()
                .anyMatch(lottoNum -> lottoNum.lottoNumber() == number.lottoNumber());
    }

    public boolean isNumberAt(int index, LottoNumber number) {
        return lottoTicket.get(index).lottoNumber() == number.lottoNumber();
    }

}
