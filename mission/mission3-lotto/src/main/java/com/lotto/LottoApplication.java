package com.lotto;

import com.lotto.controller.LottoController;

import com.lotto.service.LottoService;
import com.lotto.service.LottoTicketFactory;

import com.lotto.view.InputView;
import com.lotto.view.OutputView;

public class LottoApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        LottoTicketFactory lottoTicketFactory = new LottoTicketFactory();
        LottoService lottoService = new LottoService(lottoTicketFactory);

        LottoController lottoController = new LottoController(inputView, outputView, lottoService);

        lottoController.runLottoApp();
    }

}
