package com.lotto.service.DTO;

import java.util.List;
import java.util.Map;

public record WinningStatisticsResponseDTO(Map<Integer, Integer> matchCountMap, String ROI) {
}