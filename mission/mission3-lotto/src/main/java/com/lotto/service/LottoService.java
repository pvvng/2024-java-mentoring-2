package com.lotto.service;

import com.lotto.service.DTO.LottoTicketDTO;

import com.lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private final LottoTicketFactory lottoTicketFactory;

    public LottoService(LottoTicketFactory lottoTicketFactory){
        this.lottoTicketFactory = lottoTicketFactory;
    }

    public List<LottoTicketDTO> getLottoTickets(int lottoTicketCount) {
        List<LottoTicketDTO> lottoTicketDTOs = new ArrayList<>();

        for (int i = 0; i < lottoTicketCount; i++) {
            LottoTicket ticket = lottoTicketFactory.getLottoTicket();
            LottoTicketDTO lottoTicketDTO = new LottoTicketDTO(ticket.lottoNumbers());
            lottoTicketDTOs.add(lottoTicketDTO);
        }

        return lottoTicketDTOs;
    }

}
