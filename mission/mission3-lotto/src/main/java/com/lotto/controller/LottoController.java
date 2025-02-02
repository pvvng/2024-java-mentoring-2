package com.lotto.controller;

import com.lotto.domain.IntegerParser;
import com.lotto.domain.LottoDomain;
import com.lotto.domain.LottoNumberGenerator;
import com.lotto.domain.LottoTickets;

import com.lotto.view.InputView;
import com.lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoDomain lottoDomain;
    private final IntegerParser integerParser;
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoDomain = new LottoDomain();
        this.integerParser = new IntegerParser();
        this.lottoNumberGenerator = new LottoNumberGenerator();
    }

    public void runLottoApp() {
        outputView.showPurchaseAmount();

        String stringPurchaseAmount = inputView.getInput();
        int lottoTicketCount = getLottoTicketCount(stringPurchaseAmount);

        outputView.showPurchaseHistory(lottoTicketCount);
        outputView.showLotto(getLottoTicketsString(lottoTicketCount));
    }

    private int getLottoTicketCount(String stringPurchaseAmount) {
        int purchaseAmount = integerParser.parseInteger(stringPurchaseAmount);
        int verifiedPurchaseAmount = lottoDomain.isUnderMinimumLottoPrice(purchaseAmount);

        return lottoDomain.calculateLottoTicketCount(verifiedPurchaseAmount);
    }

    private String getLottoTicketsString(int lottoTicketCount){
        LottoTickets lottoTickets = lottoDomain.getLottoTickets(lottoNumberGenerator, lottoTicketCount);

        return lottoDomain.getFormattedLottoTickets(lottoTickets);
    }

}
