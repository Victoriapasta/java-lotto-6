package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.PrizeRank;
import lotto.dto.LottoDto;
import lotto.utils.validation.inputvalidator.InputValidator;
import lotto.view.BasicView;

import java.util.*;
import java.util.stream.Collectors;

public class LottoController {

    private final BasicView basicView;

    public LottoController(BasicView basicView) {
        this.basicView = basicView;
    }

    public void run() {
        Integer amount = initBuyAmount();
        basicView.showBuyAmount(amount);
        List<Lotto> lottoList = initLotto(amount);
        showLottoInfo(lottoList);
        List<Integer> winningNumbers = initWinningLottoNumbers();
        BonusNumber bonusNumber = initBonusNumber();
        basicView.showResult(calculatePrizeRank(lottoList, winningNumbers, bonusNumber));
    }

    public Integer initBuyAmount() {
        while (true) {
            try {
                String amount = basicView.getBuyAmount();
                Integer intAmount = Integer.valueOf(amount);
                InputValidator.buyAmountValidator(Integer.valueOf(intAmount));
                return intAmount;
            } catch (IllegalArgumentException e) {
                basicView.showErrorMessage(e.getMessage());
            }
        }
    }

    public List<Integer> initWinningLottoNumbers() {
        while (true) {
            try {
                String winningNumbers = basicView.getWinningNumbers();
                InputValidator.setWinningNumberValidator(winningNumbers);
                return Arrays.stream(winningNumbers
                                .split(","))
                        .map(s -> Integer.parseInt(s))
                        .collect(Collectors.toList());
            } catch (IllegalArgumentException e) {
                basicView.showErrorMessage(e.getMessage());
            }
        }
    }

    public BonusNumber initBonusNumber() {
        while (true) {
            try {
                String bonusNumber = basicView.getBonusNumber();
                InputValidator.setBonusNumberValidator(bonusNumber);
                return new BonusNumber(Integer.parseInt(bonusNumber));
            } catch (IllegalArgumentException e) {
                basicView.showErrorMessage(e.getMessage());
            }
        }
    }

    public List<Lotto> initLotto(Integer amount) {
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
