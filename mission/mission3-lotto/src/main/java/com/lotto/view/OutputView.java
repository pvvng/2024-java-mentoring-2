package com.lotto.view;

import com.lotto.common.PrizeMoneyConfig;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void showPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void showPurchaseHistory(int purchaseAmount) {
        System.out.println("\n" + purchaseAmount + "개를 구매했습니다.");
    }

    public void showLotto(String lotto) {
        System.out.println(lotto);
    }

    public void showWinnerNumbersPrompt() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
    }

    public void showStatisticsPrompt() {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
    }

    public void showWinStatistics(Map<Integer, Integer> statisticsMap) {
        System.out.println("3개 일치 (" + PrizeMoneyConfig.FIFTH_PLACE_PRIZE_MONEY.getPrizeMoney() + ")원- " + statisticsMap.getOrDefault(3, 0) + "개");
        System.out.println("4개 일치 (" + PrizeMoneyConfig.FOURTH_PLACE_PRIZE_MONEY.getPrizeMoney() + ")원- " + statisticsMap.getOrDefault(4, 0) + "개");
        System.out.println("5개 일치 (" + PrizeMoneyConfig.THIRD_PLACE_PRIZE_MONEY.getPrizeMoney() + ")원- " + statisticsMap.getOrDefault(5, 0) + "개");
        System.out.println("6개 일치 (" + PrizeMoneyConfig.FIRST_PLACE_PRIZE_MONEY.getPrizeMoney() + ")원- " + statisticsMap.getOrDefault(6, 0) + "개");
    }

    public void showROI(String ROI) {
        System.out.println("총 수익률은 " + ROI + "입니다.");
    }

}
