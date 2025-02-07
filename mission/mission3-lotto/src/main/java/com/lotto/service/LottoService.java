package com.lotto.service;

import com.lotto.domain.LottoTicket;
import com.lotto.domain.LottoTickets;
import com.lotto.domain.LottoTicketsGenerator;
import com.lotto.domain.Money;

import com.lotto.service.DTO.LottoResponseDTO;

import java.util.List;

public class LottoService {

    private final LottoTicketsGenerator lottoTicketsGenerator;

    public LottoService(LottoTicketsGenerator lottoTicketsGenerator) {
        this.lottoTicketsGenerator = lottoTicketsGenerator;
    }

    public LottoResponseDTO getLottoResponseDTO(int purchaseAmount){
        Money purchaseMoney = new Money(purchaseAmount);

        return new LottoResponseDTO(
                purchaseMoney.getLottoTicketAmount(),
                generateLottoTickets(purchaseMoney)
        );
    }

    private List<String> generateLottoTickets(Money purchaseMoney) {
        LottoTickets lottoTickets = lottoTicketsGenerator.getLottoTickets(purchaseMoney);

        return convertTicketsToStringList(lottoTickets);
    }

    private List<String> convertTicketsToStringList(LottoTickets lottoTickets) {
        return lottoTickets.tickets()
                .stream()
                .map(LottoTicket::toString)
                .toList();
    }

}