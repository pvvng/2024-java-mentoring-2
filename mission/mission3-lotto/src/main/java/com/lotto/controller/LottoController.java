package com.lotto.controller;

import com.lotto.view.InputView;
import com.lotto.view.OutputView;

public class LottoController {

    final private InputView inputView;
    final private OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void runLottoApp(){
        outputView.showPurchaseAmount();
        int purchaseAmount = inputView.getPurchaseAmount();
    }

}
