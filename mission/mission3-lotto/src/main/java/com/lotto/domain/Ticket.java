package com.lotto.domain;

import com.lotto.common.ErrorMessage;
import com.lotto.common.LottoConfig;
import com.lotto.common.exception.InvalidTicketLength;

import java.util.List;

public interface Ticket {

    List<LottoNumber> getTicket();

    default void validateTicketLength(List<LottoNumber> lottoTicket) {
        if (lottoTicket.size() != LottoConfig.LOTTO_TICKET_LENGTH.getConfig()) {
            throw new InvalidTicketLength(ErrorMessage.INVALID_TICKET_LENGTH_ERROR.getMessage());
        }
    }

    default boolean isContain(LottoNumber number) {
        return getTicket().stream()
                .anyMatch(lottoNum -> lottoNum.lottoNumber() == number.lottoNumber());
    }

    default boolean isNumberAt(int index, LottoNumber number) {
        return getTicket().get(index).lottoNumber() == number.lottoNumber();
    }

}
