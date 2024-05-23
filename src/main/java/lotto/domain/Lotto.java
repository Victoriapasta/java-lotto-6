package lotto.domain;

import lotto.dto.LottoDto;
import lotto.utils.exception.DuplicatedWinningNumberException;

import java.util.*;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if (isDuplicatedNumber(numbers)) {
            throw new DuplicatedWinningNumberException();
        }
    }

    public Integer countMatchNumber(List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public static Map<PrizeRank, Integer> calculatePrizeRank(List<Lotto> buyLotto, Lotto winningNumbers, BonusNumber bonusNumber) {
        Map<PrizeRank, Integer> prizeRank = new HashMap<>();

        for (Lotto lotto : buyLotto) {
            Integer matchedCount = lotto.countMatchNumber(winningNumbers.getNumbers());
            boolean matchedBonusNumber = LottoDto.toDto(lotto)
                    .getNumberDto()
                    .contains(bonusNumber.getBonusNumber());
            prizeRank.merge(PrizeRank.setRank(matchedCount, matchedBonusNumber), 1, Integer::sum);
        }
        return prizeRank;
    }

    private boolean isDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for (Integer number : numbers) {
            if (!set.add(number)) {
                return true;
            }
        }
        return false;
    }
}