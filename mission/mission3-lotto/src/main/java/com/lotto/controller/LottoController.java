package com.lotto.controller;

import com.lotto.service.LottoService;
import com.lotto.service.DTO.LottoTicketDTO;
import com.lotto.service.DTO.RequestLottoTicketCountDTO;
import com.lotto.service.DTO.ResponseLottoTicketCountDTO;

import com.lotto.view.InputView;
import com.lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void runLottoApp() {
        outputView.showPurchaseAmount();

        String stringPurchaseAmount = inputView.getInput();

        ResponseLottoTicketCountDTO responseLottoTicketCountDTO = createLottoTicketCountDTO(stringPurchaseAmount);
        int lottoTicketCount = responseLottoTicketCountDTO.purchaseAmount();

        outputView.showPurchaseHistory(lottoTicketCount);

        List<LottoTicketDTO> lottoTicketDTOs = lottoService.getLottoTicketDTOs(lottoTicketCount);
        showPurchasedLottoTickets(lottoTicketDTOs);
    }

    private ResponseLottoTicketCountDTO createLottoTicketCountDTO(String stringPurchaseAmount){
        RequestLottoTicketCountDTO requestLottoTicketCountDTO =  new RequestLottoTicketCountDTO(stringPurchaseAmount);

        return lottoService.getLottoTicketCountDTO(requestLottoTicketCountDTO);
    }

    private void showPurchasedLottoTickets(List<LottoTicketDTO> lottoTicketDTOs){
        for(LottoTicketDTO lottoTicketDTO : lottoTicketDTOs){
            outputView.showLotto(lottoTicketDTO.LottoNumbers().toString());
        }
    }

}
