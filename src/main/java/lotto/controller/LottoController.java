package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.PrizeRank;
import lotto.dto.LottoDto;
import lotto.view.BasicView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoController {

    private final BasicView basicView;

    public LottoController(BasicView basicView) {
        this.basicView = basicView;
    }

    public void run() {
        Integer amount = basicView.getBuyAmount() / 1000;
        basicView.showBuyAmount(amount);
        List<Lotto> lottoList = generateLotto(amount);
        showLottoInfo(lottoList);
        List<Integer> winningNumbers = basicView.getWinningNumbers();
        BonusNumber bonusNumber = new BonusNumber(basicView.getBonusNumber());
        basicView.showResult(calculatePrizeRank(lottoList, winningNumbers, bonusNumber));
    }

    public List<Lotto> generateLotto(Integer amount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            lottoList.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottoList;
    }

    public void showLottoInfo(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            basicView.showLottoNumbers(LottoDto.toDto(lotto));
        }
    }

    public Map<PrizeRank, Integer> calculatePrizeRank(List<Lotto> buyLotto, List<Integer> winningNumbers, BonusNumber bonusNumber) {
        return Lotto.calculatePrizeRank(buyLotto, winningNumbers, bonusNumber);
    }
}
