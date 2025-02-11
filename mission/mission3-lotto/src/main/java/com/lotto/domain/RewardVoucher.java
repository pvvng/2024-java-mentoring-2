package com.lotto.domain;

public class RewardVoucher {
    private final int matchCount;
    private final boolean bonus;

    public RewardVoucher(int matchCount, boolean bonus) {
        this.matchCount = matchCount;
        this.bonus = bonus;
    }

    public static RewardVoucher create(int matchCount, boolean bonus) {
        return new RewardVoucher(matchCount, bonus);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean hasBonus() {
        return bonus;
    }
}
