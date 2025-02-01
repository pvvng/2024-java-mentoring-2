package com.lotto.domain;

public class LottoDomain {

    public int parseStringPurchaseAmount(String userPurchaseAmount){
        return Integer.parseInt(userPurchaseAmount);
    }

    public int calculateLottoCount(int purchaseAmount){
        return purchaseAmount / 1000;
    }
}
