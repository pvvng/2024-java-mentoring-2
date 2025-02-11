package com.lotto.service.DTO;

import com.lotto.domain.LottoTickets;

public record WinningStatisticsRequestDTO(LottoTickets lottoTickets, String winnerNumbers, int purchaseAmount) {
}
