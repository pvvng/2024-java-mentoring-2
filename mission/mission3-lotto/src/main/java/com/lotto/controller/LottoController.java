package com.lotto.controller;

import com.lotto.service.DTO.LottoResponseDTO;
import com.lotto.service.DTO.WinnerRequestDTO;
import com.lotto.service.LottoService;

import com.lotto.view.InputView;
import com.lotto.view.OutputView;

public class LottoController {

    final private InputView inputView;
    final private OutputView outputView;
    final private LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService){
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void runLottoApp(){
        outputView.showPurchaseAmount();

        int purchaseAmount = inputView.getPurchaseAmount();
        LottoResponseDTO lottoResDTO = lottoService.getLottoResponseDTO(purchaseAmount);

        showTickets(lottoResDTO);

        outputView.showWinnerNumbersPrompt();
        String winnerNumbers = inputView.getWinnerString();

        lottoService.getWinningStatistics(new WinnerRequestDTO(lottoResDTO.lottoTickets(), winnerNumbers));
    }

    private void showTickets(LottoResponseDTO lottoDTO ) {
        outputView.showPurchaseHistory(lottoDTO.purchaseAmount());

        for(String ticket : lottoDTO.convertedLottoTickets()){
            outputView.showLotto(ticket);
        }
    }

}
