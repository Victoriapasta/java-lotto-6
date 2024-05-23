package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.PrizeRank;
import lotto.domain.Profit;
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
        Integer ticket = initTicket(amount);
        basicView.showBuyAmount(ticket);
        List<Lotto> lottoList = initLotto(ticket);
        showLottoInfo(lottoList);
        Lotto winningNumbers = initWinningLottoNumbers();
        BonusNumber bonusNumber = initBonusNumber();
        Map<PrizeRank, Integer> resultPrize = calculatePrizeRank(lottoList, winningNumbers, bonusNumber);
        basicView.showResult(resultPrize);
        Profit profit = initProfit(resultPrize, amount);
        basicView.showProfitRate(profit.getProfitRate());
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

    public Lotto initWinningLottoNumbers() {
        while (true) {
            try {
                String winningNumbers = basicView.getWinningNumbers();
                InputValidator.setWinningNumberValidator(winningNumbers);
                return new Lotto(Arrays.stream(winningNumbers
                                .split(","))
                        .map(s -> Integer.parseInt(s))
                        .collect(Collectors.toList()));
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

    public Integer initTicket(Integer amount) {
        return amount / 1000;
    }

    public List<Lotto> initLotto(Integer ticket) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < ticket; i++) {
            lottoList.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottoList;
    }

    public void showLottoInfo(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            basicView.showLottoNumbers(LottoDto.toDto(lotto));
        }
    }

    public Map<PrizeRank, Integer> calculatePrizeRank(List<Lotto> buyLotto, Lotto winningNumbers, BonusNumber bonusNumber) {
        return Lotto.calculatePrizeRank(buyLotto, winningNumbers, bonusNumber);
    }

    public Profit initProfit(Map<PrizeRank, Integer> result, Integer amount) {
        return Profit.calculateProfit(result, amount);
    }
}
