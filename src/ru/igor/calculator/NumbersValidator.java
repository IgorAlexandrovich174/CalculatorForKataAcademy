package ru.igor.calculator;

public class NumbersValidator {
    public void validate(ParseResult parseResult) throws Exception {
    if (parseResult.getFirstNumber() > 10 && parseResult.getSecondNumber() > 10) {
        throw new Exception("Оба числа недопустимы! Вводите числа не больше десяти!");
    }
    if (parseResult.getFirstNumber() > 10) {
        throw new Exception("Первое число недопустимо! Вводите числа не больше десяти!");
    }
    if (parseResult.getSecondNumber() > 10) {
        throw new Exception("Второе число недопустимо! Вводите числа не больше десяти!");
    }
}
}
