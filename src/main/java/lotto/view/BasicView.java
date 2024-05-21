package lotto.view;

import lotto.dto.LottoDto;
import lotto.utils.validation.inputvalidator.InputValidator;
import lotto.view.inputview.InputView;
import lotto.view.outputview.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BasicView {

    private final InputView inputView;
    private final OutputView outputView;

    public BasicView(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public Integer getBuyAmount() {
        while (true) {
            String amount = inputView.inputBuyAmount();
            try {
                Integer intAmount = Integer.valueOf(amount);
                InputValidator.buyAmountValidator(Integer.valueOf(intAmount));
                return intAmount;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 구입금액은 1000원 단위의 정수여야 합니다.");
            }
        }
    }

    public List<Integer> getWinningNumbers() {
        String winningNumbers = inputView.inputWinningNumber();
        InputValidator.setWinningNumberValidator(winningNumbers);
        return Arrays.stream(winningNumbers
                        .split(","))
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
    }

    public Integer getBonusNumber() {
        return inputView.inputBonusNumber();
    }

    public void showBuyAmount(Integer amount) {
        outputView.outputBuyAmount(amount);
    }

    public void showLottoNumbers(LottoDto lottoDto) {
        outputView.outputLotto(lottoDto);
    }
}
