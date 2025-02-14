package com.lotto.domain.generator;

import com.lotto.domain.model.Ticket;
import com.lotto.domain.vo.LottoResults;
import com.lotto.domain.vo.LottoTickets;

import java.util.List;
import java.util.stream.Collectors;

public class LottoResultsGenerator {

    private LottoResultsGenerator() {
    }

    public static LottoResults generateResults(LottoTickets lottoTickets, Ticket winnerTicket) {
        List<LottoResult> resultList = lottoTickets.tickets().stream()
                .map(ticket -> LottoResultGenerator.getResult(winnerTicket, ticket))
                .collect(Collectors.toList());

        return new LottoResults(resultList);
    }
}
