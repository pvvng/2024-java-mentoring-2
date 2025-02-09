package com.lotto.service.DTO;

import java.util.List;

public record LottoResponseDTO(int purchaseAmount, List<String> lottoTickets) {
}
