package com.lotto.service.DTO;

import java.util.List;

public record WinningStatisticsResponseDTO(List<Integer> winningStatistics, String ROI) {
}