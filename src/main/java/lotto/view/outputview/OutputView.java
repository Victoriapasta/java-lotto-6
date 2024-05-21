package lotto.view.outputview;

import lotto.dto.LottoDto;

import java.util.List;

public class OutputView {

    public void outputBuyAmount(Integer amount) {
        System.out.println(amount + "개를 구매했습니다.");
    }

    public void outputLotto(LottoDto lottoDto) {
        List<Integer> numberDto = lottoDto.getNumberDto();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < numberDto.size(); i++) {
            sb.append(numberDto.get(i));
            if (i < numberDto.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        System.out.println(sb);
    }
}
