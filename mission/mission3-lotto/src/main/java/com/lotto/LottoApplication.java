package com.lotto;

import com.lotto.domain.CustomLottoNumbersGenerator;
import com.lotto.domain.LottoTicketsGenerator;
import com.lotto.domain.LottoWinningStatisticsCalculator;

import com.lotto.service.BuildLottoTicketService;
import com.lotto.service.WinningStatisticsService;

import com.lotto.view.InputView;
import com.lotto.view.OutputView;

import com.lotto.controller.LottoController;

public class LottoApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        LottoTicketsGenerator lottoTicketsGenerator = new LottoTicketsGenerator();
        LottoWinningStatisticsCalculator statisticsCalculator = new LottoWinningStatisticsCalculator();

        BuildLottoTicketService buildLottoTicketService = new BuildLottoTicketService(lottoTicketsGenerator);
        WinningStatisticsService winningStatisticsService = new WinningStatisticsService(statisticsCalculator);

        LottoController lottoController = new LottoController(inputView, outputView, buildLottoTicketService, winningStatisticsService);

        lottoController.runLottoApp();
    }

}
