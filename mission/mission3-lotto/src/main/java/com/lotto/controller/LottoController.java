package com.lotto.controller;

import com.lotto.service.DTO.LottoResponseDTO;
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
        LottoResponseDTO lottoDTO = lottoService.getLottoResponseDTO(purchaseAmount);

        showTickets(lottoDTO);
    }

    private void showTickets(LottoResponseDTO lottoDTO ) {
        outputView.showPurchaseHistory(lottoDTO.purchaseAmount());

        for(String ticket : lottoDTO.lottoTickets()){
            outputView.showLotto(ticket);
        }
    }

}
