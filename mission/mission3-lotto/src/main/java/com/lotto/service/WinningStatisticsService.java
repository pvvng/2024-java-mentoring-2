package com.lotto.service;

import com.lotto.domain.generator.CustomLottoNumbersGenerator;
import com.lotto.domain.generator.LottoResultsGenerator;
import com.lotto.domain.model.LottoNumber;
import com.lotto.domain.model.Ticket;
import com.lotto.domain.vo.LottoResults;

import com.lotto.service.DTO.WinningStatisticsRequestDTO;
import com.lotto.service.DTO.WinningStatisticsResponseDTO;

import java.util.List;

public class WinningStatisticsService {

    public WinningStatisticsResponseDTO getResponseDTO(WinningStatisticsRequestDTO requestDTO) {
        LottoResults lottoResults = getLottoResults(requestDTO);
        String ROI = getFormattedROI(lottoResults.getTotalPrize(), requestDTO.purchaseAmount());

        return new WinningStatisticsResponseDTO(lottoResults.getMatchCountMap(), ROI);
    }

    private LottoResults getLottoResults(WinningStatisticsRequestDTO requestDTO) {
        List<LottoNumber> winnerNumbers = CustomLottoNumbersGenerator.create(requestDTO.winnerNumbers())
                .getNumbers();
        Ticket winnerTicket = Ticket.builder()
                .withNumbers(winnerNumbers)
                .build();

        return LottoResultsGenerator.generateResults(requestDTO.lottoTickets(), winnerTicket);
    }

    private String getFormattedROI(int totalPrize, int purchaseAmount) {
        float resultOfInvestment = (float) totalPrize / purchaseAmount;

        return String.format("%.2f", resultOfInvestment);
    }

}
