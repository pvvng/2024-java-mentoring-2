package com.lotto.service;

import com.lotto.service.DTO.LottoResponseDTO;

import com.lotto.domain.generator.LottoTicketsGenerator;
import com.lotto.domain.vo.Money;
import com.lotto.domain.vo.LottoTickets;
import com.lotto.domain.model.Ticket;

import java.util.List;

public class BuildLottoTicketService {

    public LottoResponseDTO getLottoResponseDTO(int purchaseAmount){
        Money purchaseMoney = new Money(purchaseAmount);

        LottoTickets lottoTickets = LottoTicketsGenerator.generateLottoTickets(purchaseMoney);

        return new LottoResponseDTO(
                purchaseMoney.getLottoTicketAmount(),
                convertTicketsToStringList(lottoTickets),
                lottoTickets
        );
    }

    private List<String> convertTicketsToStringList(LottoTickets lottoTickets) {
        return lottoTickets.tickets()
                .stream()
                .map(Ticket::toString)
                .toList();
    }

}