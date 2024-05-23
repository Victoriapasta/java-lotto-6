package lotto.dto;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LottoDto {

    private List<Integer> lottoNumberDto;

    public LottoDto(List<Integer> numberDto) {
        this.lottoNumberDto = numberDto;
    }

    public List<Integer> getNumberDto() {
        return Collections.unmodifiableList(lottoNumberDto);
    }

    public static LottoDto toDto(Lotto lotto) {
        List<Integer> numbers = new ArrayList<>(lotto.getNumbers());
        numbers.sort(Comparator.naturalOrder());
        return new LottoDto(Collections.unmodifiableList(numbers));
    }
}
