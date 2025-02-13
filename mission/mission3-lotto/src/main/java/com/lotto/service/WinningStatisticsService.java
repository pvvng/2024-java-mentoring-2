package com.lotto.service;

import com.lotto.domain.*;

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
        LottoTickets lottoTickets = requestDTO.lottoTickets();
        List<LottoNumber> winnerNumbers = new CustomLottoNumbersGenerator().getNumbers(requestDTO.winnerNumbers());
        Ticket winnerTicket = Ticket.builder()
                .withNumbers(winnerNumbers)
                .build();

        return statisticsCalculator.calculateWinningStatistics(lottoTickets, winnerTicket);
    }

    private String getFormattedROI(float resultOfInvestment) {
        return String.format("%.2f", resultOfInvestment);
    }

}
