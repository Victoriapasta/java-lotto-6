package lotto.domain;

import lotto.dto.LottoDto;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers.sort(Comparator.naturalOrder());
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public Integer countMatchNumber(List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public static Map<PrizeRank, Integer> calculatePrizeRank(List<Lotto> buyLotto, List<Integer> winningNumbers, BonusNumber bonusNumber) {
        Map<PrizeRank, Integer> prizeRank = new HashMap<>();

        for (Lotto lotto : buyLotto) {
            Integer matchedCount = lotto.countMatchNumber(winningNumbers);
            boolean matchedBonusNumber = LottoDto.toDto(lotto)
                    .getNumberDto()
                    .contains(bonusNumber.getBonusNumber());
            prizeRank.merge(PrizeRank.setRank(matchedCount, matchedBonusNumber), 1, Integer::sum);
        }
        return prizeRank;
    }
}