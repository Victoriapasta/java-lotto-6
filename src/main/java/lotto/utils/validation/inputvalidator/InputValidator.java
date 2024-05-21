package lotto.utils.validation.inputvalidator;

import lotto.utils.exception.EmptyInputException;
import lotto.utils.exception.NotDivisibleBy1000Exception;
import lotto.utils.exception.NotNumericException;

public class InputValidator {

    public static void buyAmountValidator(Integer amount) {
        if (amount % 1000 == 0) {
            return;
        }
        throw new NotDivisibleBy1000Exception();
    }

    public static void setWinningNumberValidator(String inputNumbers) {
        if (inputNumbers.isEmpty()) {
            throw new EmptyInputException();
        }
        String[] numbers = inputNumbers.split(",");
        for (String number : numbers) {
            try {
                Integer.valueOf(number);
            } catch (NotNumericException e) {
                throw new NotNumericException();
            }
        }
    }
}
