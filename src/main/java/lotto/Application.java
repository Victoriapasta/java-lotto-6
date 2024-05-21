package lotto;

import lotto.controller.LottoController;
import lotto.view.BasicView;
import lotto.view.inputview.InputView;
import lotto.view.outputview.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        BasicView basicView = new BasicView(inputView, outputView);
        LottoController lottoController = new LottoController(basicView);
        lottoController.run();
    }
}
