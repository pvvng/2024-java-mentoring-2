package com.lotto.common;

public enum MatchCountConfig {

    FIRST_PLACE_MATCH_COUNT(6),
    SECOND_PLACE_MATCH_COUNT(5),
    THIRD_PLACE_MATCH_COUNT(5),
    FOURTH_PLACE_MATCH_COUNT(4),
    FIFTH_PLACE_MATCH_COUNT(3);

    private final int matchCount;

    MatchCountConfig(int matchCount) {
        this.matchCount = matchCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

}
