package lotto.utils.validation.inputvalidator;

import lotto.utils.exception.*;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {

    public static void buyAmountValidator(Integer amount) {
        if (amount % 1000 != 0) {
            throw new NotDivisibleBy1000Exception();
        }
    }

    public static void setWinningNumberValidator(String inputNumbers) {
        if (inputNumbers.isEmpty()) {
            throw new EmptyInputException();
        }
        String[] numbers = inputNumbers.split(",");
        if (numbers.length > 6) {
            throw new OverSizeLottoException();
        }
        for (String number : numbers) {
            try {
                Integer.valueOf(number);
            } catch (NotNumericException e) {
                throw new NotNumericException();
            }
        }
    }

    public static void setBonusNumberValidator(String inputNumber) {
        if (inputNumber.isEmpty()) {
            throw new EmptyInputException();
        }

        try {
            Integer.valueOf(inputNumber);
        } catch (NotNumericException e) {
            throw new NotNumericException();
        }
    }
}
