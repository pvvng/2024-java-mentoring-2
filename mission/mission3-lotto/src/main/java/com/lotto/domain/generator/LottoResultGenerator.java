package com.lotto.domain.generator;

import com.lotto.domain.model.Ticket;

import com.lotto.common.LottoConfig;

public class LottoResultGenerator implements LottoResult {

    private final int matchCount;
    private final boolean hasBonus;

    private LottoResultGenerator(Ticket winnerTicket, Ticket nowTicket) {
        this.matchCount = getTicketMatchCount(winnerTicket, nowTicket);
        this.hasBonus = isBonusMatch(nowTicket, winnerTicket.getBonus());
    }

    public static LottoResultGenerator getResult(Ticket winnerTicket, Ticket nowTicket) {
        return new LottoResultGenerator(winnerTicket, nowTicket);
    }

    @Override
    public int getMatchCount() {
        return matchCount;
    }

    @Override
    public boolean hasBonus() {
        return hasBonus;
    }

    private int getTicketMatchCount(Ticket winnerTicket, Ticket nowTicket) {
        int count = 0;

        for (int i = 0; i < LottoConfig.LOTTO_TICKET_LENGTH.getConfig(); i++) {
            int winNumber = winnerTicket.getNumber(i);
            boolean isWin = nowTicket.isNumberAt(i, winNumber);

            count += countUp(isWin);
        }

        return count;
    }

    private int countUp(boolean isWin) {
        if (isWin) {
            return 1;
        }

        return 0;
    }

    private boolean isBonusMatch(Ticket nowTicket, int bonusNumber) {
        return nowTicket.getLottoNumbers().stream()
                .anyMatch(v -> v.lottoNumber() == bonusNumber);
    }

}
