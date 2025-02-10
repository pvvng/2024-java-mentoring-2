package com.lotto.controller;

import com.lotto.service.DTO.LottoResponseDTO;
import com.lotto.service.DTO.WinnerRequestDTO;

import com.lotto.service.BuildLottoTicketService;
import com.lotto.service.WinningStatisticsService;

import com.lotto.view.InputView;
import com.lotto.view.OutputView;

import java.util.Map;

public class LottoController {

    final private InputView inputView;
    final private OutputView outputView;
    final private BuildLottoTicketService buildLottoTicketService;
    final private WinningStatisticsService winningStatisticsService;

    public LottoController(InputView inputView, OutputView outputView, BuildLottoTicketService buildLottoTicketService, WinningStatisticsService winningStatisticsService){
        this.inputView = inputView;
        this.outputView = outputView;
        this.buildLottoTicketService = buildLottoTicketService;
        this.winningStatisticsService = winningStatisticsService;
    }

    public void runLottoApp(){
        outputView.showPurchaseAmount();

        int purchaseAmount = inputView.getPurchaseAmount();
        LottoResponseDTO lottoResDTO = buildLottoTicketService.getLottoResponseDTO(purchaseAmount);

        showTickets(lottoResDTO);

        outputView.showWinnerNumbersPrompt();
        String winnerNumbers = inputView.getWinnerString();

        WinnerRequestDTO winnerReqDTO = createWinnerRequestDTO(lottoResDTO, winnerNumbers);
        Map<Integer, Integer> lottoStatistics = winningStatisticsService.getLottoStatistics(winnerReqDTO);

        outputView.showWinStatistics(lottoStatistics);
    }

    private void showTickets(LottoResponseDTO lottoDTO ) {
        outputView.showPurchaseHistory(lottoDTO.purchaseAmount());

        for(String ticket : lottoDTO.convertedLottoTickets()){
            outputView.showLotto(ticket);
        }
    }

    private WinnerRequestDTO createWinnerRequestDTO(LottoResponseDTO lottoResponseDTO, String winnerNumbers) {
        return new WinnerRequestDTO(lottoResponseDTO.lottoTickets(), winnerNumbers);
    }

}
