package lotto.domain;

import java.util.Map;

public class Profit {

    private final Double profitRate;

    public Profit(Double profitRate) {
        this.profitRate = profitRate;
    }

    public Double getProfitRate() {
        return profitRate;
    }

    public static Profit calculateProfit(Map<PrizeRank, Integer> result, Integer amount) {
        Long totalReward = result.keySet().stream()
                .mapToLong(key -> result.get(key) * key.getReward())
                .sum();
        return new Profit((double) totalReward / amount);
    }
}
