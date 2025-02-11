package com.lotto.domain;

import com.lotto.common.MatchCountConfig;
import com.lotto.common.PrizeMoneyConfig;

public class LottoPrizeCalculator {

    public int getPrize(RewardVoucher voucher) {
        return calculatePrize(voucher.getMatchCount(), voucher.hasBonus());
    }

    private int calculatePrize(int matchCount, boolean bonus) {

        if (matchCount == MatchCountConfig.FIRST_PLACE_MATCH_COUNT.getMatchCount() && !bonus) {
            return PrizeMoneyConfig.FIRST_PLACE_PRIZE_MONEY.getPrizeMoney();
        }

        if (matchCount == MatchCountConfig.SECOND_PLACE_MATCH_COUNT.getMatchCount() && bonus) {
            return PrizeMoneyConfig.SECOND_PLACE_PRIZE_MONEY.getPrizeMoney();
        }

        if (matchCount == MatchCountConfig.THIRD_PLACE_MATCH_COUNT.getMatchCount() && !bonus) {
            return PrizeMoneyConfig.THIRD_PLACE_PRIZE_MONEY.getPrizeMoney();
        }

        if (matchCount == MatchCountConfig.FOURTH_PLACE_MATCH_COUNT.getMatchCount()) {
            return PrizeMoneyConfig.FOURTH_PLACE_PRIZE_MONEY.getPrizeMoney();
        }

        if (matchCount == MatchCountConfig.FIFTH_PLACE_MATCH_COUNT.getMatchCount()) {
            return PrizeMoneyConfig.FIFTH_PLACE_PRIZE_MONEY.getPrizeMoney();
        }

        return 0;
    }

}
