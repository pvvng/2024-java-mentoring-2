package com.lotto;

import com.lotto.service.BuildLottoTicketService;
import com.lotto.service.WinningStatisticsService;

import com.lotto.view.InputView;
import com.lotto.view.OutputView;

import com.lotto.controller.LottoController;

public class LottoApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        BuildLottoTicketService buildLottoTicketService = new BuildLottoTicketService();
        WinningStatisticsService winningStatisticsService = new WinningStatisticsService();

        LottoController lottoController = new LottoController(inputView, outputView, buildLottoTicketService, winningStatisticsService);

        lottoController.runLottoApp();
    }

}
