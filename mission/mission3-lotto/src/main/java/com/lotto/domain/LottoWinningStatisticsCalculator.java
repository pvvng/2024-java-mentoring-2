package com.lotto.domain;

import com.lotto.common.LottoConfig;

public class LottoWinningStatisticsCalculator {
    public void calculateWinningStatistics(LottoTickets lottoTickets, WinnerTicket winnerTicket) {
        for (int ticketIndex = 0; ticketIndex < lottoTickets.tickets().size(); ticketIndex++) {
            int count = 0;
            LottoTicket nowTicket = lottoTickets.tickets().get(ticketIndex);
            for (int i = 0; i < LottoConfig.LOTTO_TICKET_LENGTH.getConfig(); i++) {
                int winnerNumber = winnerTicket.getNumber(i);
                boolean isWin = nowTicket.isNumberAt(i, winnerNumber);

                if(isWin) {
                    count++;
                }
            }
        }
    }
}
