package com.lotto.domain;

import com.lotto.common.LottoConfig;

import java.util.ArrayList;
import java.util.List;

public class LottoWinningStatisticsCalculator {

    public List<Integer> calculateWinningStatistics(LottoTickets lottoTickets, WinnerTicket winnerTicket) {
        List<Integer> statisticsList = new ArrayList<>();

        for (int ticketIndex = 0; ticketIndex < lottoTickets.tickets().size(); ticketIndex++) {
            int winCount = loopLottoTickets(winnerTicket, lottoTickets, ticketIndex);

            statisticsList.add(winCount);
        }

        return statisticsList;
    }

    public int getTotalPrize(List<Integer> statisticsList) {
        int prizeSum = 0;

        for (int matchCount : statisticsList) {
            prizeSum += getPrize(getRewardVoucher(matchCount, false));
        }

        return prizeSum;
    }

    private RewardVoucher getRewardVoucher(int matchCount, boolean bonus) {
        return RewardVoucher.create(matchCount, bonus);
    }

    private int getPrize(RewardVoucher voucher) {
        LottoPrizeCalculator calculator = new LottoPrizeCalculator();

        return calculator.getPrize(voucher);
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

}
