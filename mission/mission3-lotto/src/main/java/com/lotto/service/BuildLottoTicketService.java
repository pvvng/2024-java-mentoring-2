package com.lotto.service;

import com.lotto.domain.LottoTicketsGenerator;
import com.lotto.domain.Money;
import com.lotto.domain.LottoTickets;
import com.lotto.domain.LottoTicket;

import com.lotto.service.DTO.LottoResponseDTO;

import java.util.List;

public class BuildLottoTicketService {

    private final LottoTicketsGenerator lottoTicketsGenerator;

    public BuildLottoTicketService(LottoTicketsGenerator lottoTicketsGenerator) {
        this.lottoTicketsGenerator = lottoTicketsGenerator;
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

    private List<String> convertTicketsToStringList(LottoTickets lottoTickets) {
        return lottoTickets.tickets()
                .stream()
                .map(LottoTicket::toString)
                .toList();
    }

}