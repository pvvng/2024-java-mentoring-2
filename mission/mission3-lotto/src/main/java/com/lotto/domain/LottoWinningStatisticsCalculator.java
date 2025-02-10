package com.lotto.domain;

import com.lotto.common.LottoConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoWinningStatisticsCalculator {

    public Map<Integer, Integer> calculateWinningStatistics(LottoTickets lottoTickets, WinnerTicket winnerTicket) {
        List<Integer> statisticsList = new ArrayList<>();

        for (int ticketIndex = 0; ticketIndex < lottoTickets.tickets().size(); ticketIndex++) {
            int winCount = loopLottoTickets(winnerTicket, lottoTickets, ticketIndex);

            statisticsList.add(winCount);
        }

        return getStatisticsMap(statisticsList);
    }

    private int loopLottoTickets(WinnerTicket winnerTicket, LottoTickets lottoTickets, int ticketIndex) {
        int count = 0;
        LottoTicket nowTicket = lottoTickets.tickets().get(ticketIndex);

        for (int i = 0; i < LottoConfig.LOTTO_TICKET_LENGTH.getConfig(); i++) {
            int winNumber = winnerTicket.getNumber(i);
            boolean isWin = nowTicket.isNumberAt(i, winNumber);

            count += countUp(isWin);
        }

        return count;
    }

    private int countUp(boolean isBoolean) {
        if (isBoolean) {
            return 1;
        }

        return 0;
    }

    private Map<Integer, Integer> getStatisticsMap(List<Integer> statisticsList) {
        Map<Integer, Integer> statisticsMap = getFormattedStatisticsMap();

        for (int countKey : statisticsList) {
            statisticsMap.put(countKey, (statisticsMap.getOrDefault(countKey, 0) + 1));
        }

        return statisticsMap;
    }

    private Map<Integer, Integer> getFormattedStatisticsMap() {
        return Stream.of(0, 1, 2, 3, 4, 5, 6)
                .collect(Collectors.toMap(Function.identity(), v -> 0));
    }

}
