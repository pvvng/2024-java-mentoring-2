package com.lotto.service.DTO;

import com.lotto.domain.vo.LottoTickets;

public record WinningStatisticsRequestDTO(LottoTickets lottoTickets, String winnerNumbers, int purchaseAmount) {
}
