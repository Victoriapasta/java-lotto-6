package lotto.dto;

import lotto.domain.Lotto;

import java.util.List;

public class LottoDto {

    private List<Integer> lottoNumberDto;

    public LottoDto(List<Integer> numberDto) {
        this.lottoNumberDto = numberDto;
    }

    public List<Integer> getNumberDto() {
        return lottoNumberDto;
    }

    public static LottoDto toDto(Lotto lotto) {
        return new LottoDto(lotto.getNumbers());
    }
}
