package com.lotto.view;

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
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public void showStatisticsPrompt() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

}
