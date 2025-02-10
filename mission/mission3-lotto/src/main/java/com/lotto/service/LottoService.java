package com.lotto.service;

import com.lotto.domain.LottoTicketsGenerator;
import com.lotto.domain.WinnerTicketGenerator;
import com.lotto.domain.LottoWinningStatisticsCalculator;
import com.lotto.domain.Money;
import com.lotto.domain.LottoTickets;
import com.lotto.domain.WinnerTicket;
import com.lotto.domain.LottoTicket;

import com.lotto.service.DTO.LottoResponseDTO;
import com.lotto.service.DTO.WinnerRequestDTO;

import java.util.List;
import java.util.Map;

public class LottoService {

    private final LottoTicketsGenerator lottoTicketsGenerator;
    private final WinnerTicketGenerator winnerTicketGenerator;
    private final LottoWinningStatisticsCalculator statisticsCalculator;

    public LottoService(LottoTicketsGenerator lottoTicketsGenerator, WinnerTicketGenerator winnerTicketGenerator, LottoWinningStatisticsCalculator statisticsCalculator) {
        this.lottoTicketsGenerator = lottoTicketsGenerator;
        this.winnerTicketGenerator = winnerTicketGenerator;
        this.statisticsCalculator = statisticsCalculator;
    }

    public LottoResponseDTO getLottoResponseDTO(int purchaseAmount){
        Money purchaseMoney = new Money(purchaseAmount);

        LottoTickets lottoTickets = lottoTicketsGenerator.getLottoTickets(purchaseMoney);

        return new LottoResponseDTO(
                purchaseMoney.getLottoTicketAmount(),
                convertTicketsToStringList(lottoTickets),
                lottoTickets
        );
    }

    public Map<Integer, Integer> getLottoStatistics(WinnerRequestDTO requestDTO) {
        LottoTickets lottoTickets = requestDTO.lottoTickets();
        WinnerTicket winnerTicket = winnerTicketGenerator.getWinnerTicket(requestDTO.winnerNumbers());

        Map<Integer, Integer> winningStatistics = statisticsCalculator.calculateWinningStatistics(lottoTickets, winnerTicket);
        return statisticsCalculator.calculateWinningStatistics(lottoTickets, winnerTicket);
    }

    private List<String> convertTicketsToStringList(LottoTickets lottoTickets) {
        return lottoTickets.tickets()
                .stream()
                .map(LottoTicket::toString)
                .toList();
    }

}