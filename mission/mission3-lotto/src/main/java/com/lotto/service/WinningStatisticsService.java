package com.lotto.service;

import com.lotto.domain.LottoTickets;
import com.lotto.domain.LottoWinningStatisticsCalculator;
import com.lotto.domain.WinnerTicket;
import com.lotto.domain.WinnerTicketGenerator;

import com.lotto.service.DTO.WinnerRequestDTO;

import java.util.Map;

public class WinningStatisticsService {

    private final WinnerTicketGenerator winnerTicketGenerator;
    private final LottoWinningStatisticsCalculator statisticsCalculator;

    public WinningStatisticsService(WinnerTicketGenerator winnerTicketGenerator, LottoWinningStatisticsCalculator statisticsCalculator) {
        this.winnerTicketGenerator = winnerTicketGenerator;
        this.statisticsCalculator = statisticsCalculator;
    }

    public Map<Integer, Integer> getLottoStatistics(WinnerRequestDTO requestDTO) {
        LottoTickets lottoTickets = requestDTO.lottoTickets();
        WinnerTicket winnerTicket = winnerTicketGenerator.getWinnerTicket(requestDTO.winnerNumbers());

        Map<Integer, Integer> winningStatistics = statisticsCalculator.calculateWinningStatistics(lottoTickets, winnerTicket);
        return statisticsCalculator.calculateWinningStatistics(lottoTickets, winnerTicket);
    }
}
