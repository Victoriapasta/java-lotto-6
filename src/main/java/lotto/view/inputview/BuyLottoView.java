package lotto.view.inputview;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.validation.IsDivisibleBy1000;

public class BuyLottoView {

    Integer amount;

    public Integer buyLottoView() {
        System.out.println("구입금액을 입력해 주세요.");
        amount = Integer.parseInt(Console.readLine());
        IsDivisibleBy1000.isDivisibleBy1000(amount);
        return amount;
    }
}
