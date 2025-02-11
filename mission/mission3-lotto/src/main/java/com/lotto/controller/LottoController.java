package com.lotto.controller;

import com.lotto.service.DTO.LottoResponseDTO;
import com.lotto.service.DTO.WinningStatisticsRequestDTO;

import com.lotto.service.BuildLottoTicketService;
import com.lotto.service.DTO.WinningStatisticsResponseDTO;
import com.lotto.service.WinningStatisticsService;

import com.lotto.view.InputView;
import com.lotto.view.OutputView;

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

        WinningStatisticsRequestDTO winningReqDTO = createWinnerRequestDTO(lottoResDTO, winnerNumbers, purchaseAmount);
        WinningStatisticsResponseDTO winningResDTO = winningStatisticsService.getResponseDTO(winningReqDTO);

        showLottoResult(winningResDTO);
    }

    private void showTickets(LottoResponseDTO lottoDTO ) {
        outputView.showPurchaseHistory(lottoDTO.purchaseAmount());

        for(String ticket : lottoDTO.convertedLottoTickets()){
            outputView.showLotto(ticket);
        }
    }

    private WinningStatisticsRequestDTO createWinnerRequestDTO(LottoResponseDTO lottoResponseDTO, String winnerNumbers, int purchaseAmount) {
        return new WinningStatisticsRequestDTO(lottoResponseDTO.lottoTickets(), winnerNumbers, purchaseAmount);
    }

    private void showLottoResult(WinningStatisticsResponseDTO winningResDTO) {
        outputView.showStatisticsPrompt();
        outputView.showWinStatistics(winningResDTO.matchCountMap());
        outputView.showROI(winningResDTO.ROI());
    }

}
