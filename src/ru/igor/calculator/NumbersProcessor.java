package ru.igor.calculator;

public class NumbersProcessor {
    public int processNumbers(ParseResult parseResult) throws Exception {
        String operator = parseResult.getOperator();
        int result = 0;
        result = switch (operator) {
            case "+" -> parseResult.getFirstNumber() + parseResult.getSecondNumber();
            case "-" -> parseResult.getFirstNumber() - parseResult.getSecondNumber();
            case "*" -> parseResult.getFirstNumber() * parseResult.getSecondNumber();
            case "/" -> parseResult.getFirstNumber() / parseResult.getSecondNumber();
            default -> throw new Exception();
        };
        return result;
    }
}
