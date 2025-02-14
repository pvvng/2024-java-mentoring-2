package com.lotto.domain;

import com.lotto.common.MatchCountConfig;
import com.lotto.common.PrizeMoneyConfig;

import java.util.Map;

public class LottoPrizeCalculator {

    private static final Map<Integer, Integer> PRIZE_MONEY = Map.of(
            MatchCountConfig.FIRST_PLACE_MATCH_COUNT.getMatchCount(), PrizeMoneyConfig.FIRST_PLACE_PRIZE_MONEY.getPrizeMoney(),
            MatchCountConfig.THIRD_PLACE_MATCH_COUNT.getMatchCount(), PrizeMoneyConfig.THIRD_PLACE_PRIZE_MONEY.getPrizeMoney(),
            MatchCountConfig.FOURTH_PLACE_MATCH_COUNT.getMatchCount(), PrizeMoneyConfig.FOURTH_PLACE_PRIZE_MONEY.getPrizeMoney(),
            MatchCountConfig.FIFTH_PLACE_MATCH_COUNT.getMatchCount(), PrizeMoneyConfig.FIFTH_PLACE_PRIZE_MONEY.getPrizeMoney()
    );

    public static int getPrize(int matchCount, boolean bonus) {
        if (matchCount == MatchCountConfig.SECOND_PLACE_MATCH_COUNT.getMatchCount() && bonus) {
            return PrizeMoneyConfig.SECOND_PLACE_PRIZE_MONEY.getPrizeMoney();
        }

        return PRIZE_MONEY.getOrDefault(matchCount, 0);
    }

}
