package com.lotto.service.DTO;

import com.lotto.domain.LottoTickets;

public record WinnerRequestDTO(LottoTickets lottoTickets, String winnerNumbers) {
}
