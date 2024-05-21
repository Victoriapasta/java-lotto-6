package lotto.dto;

import lotto.Lotto;

import java.util.List;

public class LottoDto {

    private List<Integer> numberDto;

    public LottoDto(List<Integer> numberDto) {
        this.numberDto = numberDto;
    }

    public static LottoDto toDto(Lotto lotto) {
        return new LottoDto(lotto.getNumbers());
    }
}
