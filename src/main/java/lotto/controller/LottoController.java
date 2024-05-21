package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.dto.LottoDto;
import lotto.view.BasicView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private final BasicView basicView;

    public LottoController(BasicView basicView) {
        this.basicView = basicView;
    }

    public void run() {
        Integer amount = basicView.getBuyAmount() / 1000;
        basicView.showBuyAmount(amount);
        List<Lotto> lottoList = generateLotto(amount);
        for (Lotto lotto : lottoList) {
            basicView.showLottoNumbers(LottoDto.toDto(lotto));
        }
        basicView.getWinningNumbers();

    }

    public List<Lotto> generateLotto(Integer amount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            lottoList.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottoList;
    }
}
