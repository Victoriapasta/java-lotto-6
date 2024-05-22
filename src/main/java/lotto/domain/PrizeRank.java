package lotto.domain;

public enum PrizeRank {

    FIRST(6, false),
    SECOND(5, true),
    THIRD(5, false),
    FOURTH(4, false),
    FIFTH(3, false),
    OTHERS(0, false);

    private final Integer matchedNumber;
    private final boolean matchedBonusNumber;

    PrizeRank(Integer matchedNumber, boolean matchedBonusNumber) {
        this.matchedNumber = matchedNumber;
        this.matchedBonusNumber = matchedBonusNumber;
    }

    public static PrizeRank setRank(Integer matchedNumber, boolean matchedBonusNumber) {
        for (PrizeRank prizeRank : PrizeRank.values()) {
            if (prizeRank.matchedNumber.equals(matchedNumber) && prizeRank.matchedBonusNumber == matchedBonusNumber) {
                return prizeRank;
            }
        }
        return OTHERS;
    }
}
