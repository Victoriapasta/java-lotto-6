package lotto.view.inputview;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.exception.IsNotDivisibleBy1000Amount;
import lotto.utils.validation.IsDivisibleBy1000;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public Integer buyLottoView() {
        Integer amount;
        System.out.println("구입금액을 입력해 주세요.");
        amount = Integer.parseInt(Console.readLine());
        try {
            IsDivisibleBy1000.isDivisibleBy1000(amount);
        } catch (IsNotDivisibleBy1000Amount e) {
            System.out.println("[ERROR] 구입금액은 1000원 단위어야 합니다.");
        }
        return amount;
    }

    public List<Integer> inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Arrays.stream(Console.readLine()
                        .split(","))
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
    }

    public Integer inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
