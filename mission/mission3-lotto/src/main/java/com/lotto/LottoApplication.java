package com.lotto;

import com.lotto.view.InputView;
import com.lotto.view.OutputView;

import com.lotto.controller.LottoController;

import com.lotto.domain.LottoNumberGenerator;
import com.lotto.domain.LottoTicketsGenerator;
import com.lotto.domain.RandomNumberGenerator;

import com.lotto.service.LottoService;

public class LottoApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        RandomNumberGenerator randomNumberGenerator = new LottoNumberGenerator();
        LottoTicketsGenerator lottoTicketsGenerator = new LottoTicketsGenerator(randomNumberGenerator);

        LottoService lottoService = new LottoService(lottoTicketsGenerator);

        LottoController lottoController = new LottoController(inputView, outputView, lottoService);

        lottoController.runLottoApp();
    }

}
