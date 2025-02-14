package com.lotto.service;

import com.lotto.domain.CustomLottoNumbersGenerator;
import com.lotto.domain.LottoNumber;
import com.lotto.domain.LottoWinningStatisticsCalculator;
import com.lotto.domain.Ticket;

import com.lotto.service.DTO.WinningStatisticsRequestDTO;
import com.lotto.service.DTO.WinningStatisticsResponseDTO;

import java.util.List;
import java.util.Map;

public class WinningStatisticsService {

    private final LottoWinningStatisticsCalculator statisticsCalculator;

    public WinningStatisticsService(LottoWinningStatisticsCalculator statisticsCalculator) {
        this.statisticsCalculator = statisticsCalculator;
    }

    public WinningStatisticsResponseDTO getResponseDTO(WinningStatisticsRequestDTO requestDTO) {
        List<Integer> winningStatistics = getLottoStatistics(requestDTO);

        int totalPrize = statisticsCalculator.getTotalPrize(winningStatistics);
        Map<Integer, Integer> matchCountMap = statisticsCalculator.getMatchCountMap(winningStatistics);

        float resultOfInvestment = (float) totalPrize / requestDTO.purchaseAmount();

        return new WinningStatisticsResponseDTO(matchCountMap, getFormattedROI(resultOfInvestment));
    }

    private List<Integer> getLottoStatistics(WinningStatisticsRequestDTO requestDTO) {
        List<LottoNumber> winnerNumbers = CustomLottoNumbersGenerator.getNumbers(requestDTO.winnerNumbers());
        Ticket winnerTicket = Ticket.builder()
                .withNumbers(winnerNumbers)
                .build();

        return statisticsCalculator.calculateWinningStatistics(requestDTO.lottoTickets(), winnerTicket);
    }

    private String getFormattedROI(float resultOfInvestment) {
        return String.format("%.2f", resultOfInvestment);
    }

}
