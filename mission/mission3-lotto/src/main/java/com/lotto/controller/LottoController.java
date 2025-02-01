package com.lotto.controller;

import com.lotto.view.InputView;
import com.lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void buyLotto(){
        outputView.showPurchaseAmount();
        String userPurchaseAmount = inputView.getInput();
    }
}
