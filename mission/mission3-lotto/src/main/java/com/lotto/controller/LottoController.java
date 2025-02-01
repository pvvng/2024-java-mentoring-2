package com.lotto.controller;

import com.lotto.domain.IntegerParser;
import com.lotto.domain.LottoDomain;
import com.lotto.view.InputView;
import com.lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoDomain lottoDomain;
    private final IntegerParser integerParser;

    public LottoController(InputView inputView, OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoDomain = new LottoDomain();
        this.integerParser = new IntegerParser();
    }

    public void buyLotto(){
        outputView.showPurchaseAmount();

        String stringPurchaseAmount = inputView.getInput();

        int purchaseAmount = integerParser.parseInteger(stringPurchaseAmount);
        purchaseAmount = lottoDomain.isUnderMinimumLottoPrice(purchaseAmount);
        int lottoTicketCount = lottoDomain.calculateLottoTicketCount(purchaseAmount);
    }
}
