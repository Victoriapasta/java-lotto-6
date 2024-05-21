package lotto.utils.validation;

import lotto.utils.exception.IsNotDivisibleBy1000Amount;

public class IsDivisibleBy1000 {

    public static void isDivisibleBy1000(Integer amount) {
        if (amount % 1000 == 0) {
            return;
        }
        throw new IsNotDivisibleBy1000Amount();
    }
}
