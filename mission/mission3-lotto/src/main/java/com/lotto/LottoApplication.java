package com.lotto;

import com.lotto.controller.LottoController;
import com.lotto.view.InputView;
import com.lotto.view.OutputView;

public class LottoApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        LottoController lottoController = new LottoController(inputView, outputView);

        lottoController.buyLotto();

    }
}
