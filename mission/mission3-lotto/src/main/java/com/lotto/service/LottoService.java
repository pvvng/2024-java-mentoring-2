package com.lotto.service;

import com.lotto.domain.IntegerParser;
import com.lotto.domain.LottoDomain;
import com.lotto.service.DTO.LottoTicketDTO;

import com.lotto.domain.LottoTicket;
import com.lotto.service.DTO.RequestLottoTicketCountDTO;
import com.lotto.service.DTO.ResponseLottoTicketCountDTO;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private final LottoTicketFactory lottoTicketFactory;
    private final IntegerParser integerParser = new IntegerParser();
    private final LottoDomain lottoDomain = new LottoDomain();

    public LottoService(LottoTicketFactory lottoTicketFactory) {
        this.lottoTicketFactory = lottoTicketFactory;
    }

    public ResponseLottoTicketCountDTO getLottoTicketCountDTO(RequestLottoTicketCountDTO requestDTO) {
        String stringPurchaseAmount = requestDTO.stringPurchaseAmount();

        int lottoTicketCount = getLottoTicketCount(stringPurchaseAmount);

        return new ResponseLottoTicketCountDTO(lottoTicketCount);
    }

    public List<LottoTicketDTO> getLottoTicketDTOs(int lottoTicketCount) {
        List<LottoTicketDTO> lottoTicketDTOs = new ArrayList<>();

        for (int i = 0; i < lottoTicketCount; i++) {
            LottoTicket lottoTicket = lottoTicketFactory.getLottoTicket();
            lottoTicketDTOs.add(createLottoTicketDTO(lottoTicket));
        }

        return lottoTicketDTOs;
    }

    private LottoTicketDTO createLottoTicketDTO(LottoTicket lottoTicket){

        return new LottoTicketDTO(lottoTicket.lottoNumbers());
    }

    private int getLottoTicketCount(String stringPurchaseAmount) {
        int purchaseAmount = integerParser.parseInteger(stringPurchaseAmount);
        int verifiedPurchaseAmount = lottoDomain.isUnderMinimumLottoPrice(purchaseAmount);

        return lottoDomain.calculateLottoTicketCount(verifiedPurchaseAmount);
    }

}
