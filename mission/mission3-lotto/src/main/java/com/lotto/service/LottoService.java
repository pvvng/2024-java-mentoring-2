package com.lotto.service;

import com.lotto.domain.LottoTicketsGenerator;
import com.lotto.domain.WinnerTicketGenerator;
import com.lotto.domain.Money;
import com.lotto.domain.LottoTickets;
import com.lotto.domain.WinnerTicket;
import com.lotto.domain.LottoTicket;

import com.lotto.service.DTO.LottoResponseDTO;
import com.lotto.service.DTO.WinnerRequestDTO;

import java.util.List;

public class LottoService {

    private final LottoTicketsGenerator lottoTicketsGenerator;
    private final WinnerTicketGenerator winnerTicketGenerator;

    public LottoService(LottoTicketsGenerator lottoTicketsGenerator, WinnerTicketGenerator winnerTicketGenerator) {
        this.lottoTicketsGenerator = lottoTicketsGenerator;
        this.winnerTicketGenerator = winnerTicketGenerator;
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

    public void getWinningStatistics(WinnerRequestDTO requestDTO) {
        WinnerTicket winnerTicket = winnerTicketGenerator.getWinnerTicket(requestDTO.winnerNumbers());
        LottoTickets lottoTickets = requestDTO.lottoTickets();

    }

    private List<String> convertTicketsToStringList(LottoTickets lottoTickets) {
        return lottoTickets.tickets()
                .stream()
                .map(LottoTicket::toString)
                .toList();
    }

}