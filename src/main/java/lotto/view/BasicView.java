package lotto.view;

import lotto.domain.PrizeRank;
import lotto.dto.LottoDto;
import lotto.view.inputview.InputView;
import lotto.view.outputview.OutputView;

import java.util.Map;

public class BasicView {

    private final InputView inputView;
    private final OutputView outputView;

    public BasicView(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public String getBuyAmount() {
        return inputView.inputBuyAmount();
    }

    public String getWinningNumbers() {
        return inputView.inputWinningNumber();
    }

    public String getBonusNumber() {
        return inputView.inputBonusNumber();
    }

    public void showBuyAmount(Integer amount) {
        outputView.outputBuyAmount(amount);
    }

    public void showLottoNumbers(LottoDto lottoDto) {
        outputView.outputLotto(lottoDto);
    }

    public void showResult(Map<PrizeRank, Integer> result) {
        outputView.outputPrizedRank(result);
    }

    public void showErrorMessage(String message) {
        outputView.printErrorMessage(message);
    }
}
