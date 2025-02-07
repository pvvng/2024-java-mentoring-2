package com.lotto.domain;

import com.lotto.common.ErrorMessage;
import com.lotto.common.LottoConfig;
import com.lotto.common.exception.InvalidTicketLength;

import java.util.List;

public class LottoTicket {

    private final List<LottoNumber> lottoTicket;

    public LottoTicket(List<LottoNumber> lottoTicket) {
        validateTicketLength(lottoTicket);

        this.lottoTicket = lottoTicket;
    }

    private void validateTicketLength(List<LottoNumber> lottoTicket){
        if(lottoTicket.size() != LottoConfig.LOTTO_TICKET_LENGTH){
            throw new InvalidTicketLength(ErrorMessage.INVALID_TICKET_LENGTH_ERROR.getMessage());
        }
    }

}
