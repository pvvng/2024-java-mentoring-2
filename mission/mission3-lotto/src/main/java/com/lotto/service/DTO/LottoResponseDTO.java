package com.lotto.service.DTO;

import com.lotto.domain.LottoTickets;

import java.util.List;

public record LottoResponseDTO(int purchaseAmount, List<String> convertedLottoTickets, LottoTickets lottoTickets) {
}
