package com.lotto.domain;

import com.lotto.common.ErrorMessage;
import com.lotto.common.LottoConfig;
import com.lotto.common.exception.InvalidTicketLength;

import java.util.List;

public record LottoTicket(List<LottoNumber> lottoTicket) {

    public LottoTicket {
        validateTicketLength(lottoTicket);
    }

    @Override
    public String toString() {
        return lottoTicket.stream()
                .map(LottoNumber::getLottoNumber)
                .toList()
                .toString();
    }

    private void validateTicketLength(List<LottoNumber> lottoTicket) {
        if (lottoTicket.size() != LottoConfig.LOTTO_TICKET_LENGTH) {
            throw new InvalidTicketLength(ErrorMessage.INVALID_TICKET_LENGTH_ERROR.getMessage());
        }
    }

}
