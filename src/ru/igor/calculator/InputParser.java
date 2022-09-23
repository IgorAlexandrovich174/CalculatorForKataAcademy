package ru.igor.calculator;

public class InputParser {
    private RomanNumbersService romanNumbersService;

    InputParser() {
    }

    public InputParser(RomanNumbersService romanNumbersService) {
        this.romanNumbersService = romanNumbersService;
    }

    public ParseResult parseStr(String inputValues) throws Exception {

        Integer indexOperator = null;
        String operator = null;

        for (int i = 0; i < inputValues.length(); i++) {
            char value = inputValues.charAt(i);
            if (value == '+') {
                indexOperator = i;
                operator = "+";
                break;
            }
            if (value == '-') {
                indexOperator = i;
                operator = "-";
                break;
            }
            if (value == '*') {
                indexOperator = i;
                operator = "*";
                break;
            }
            if (value == '/') {
                indexOperator = i;
                operator = "/";
                break;
            }

        }
        if (indexOperator == null) {
            throw new Exception("Введён неверный оператор!");
        }
        String firstNumberAsString = inputValues.substring(0, indexOperator);
        String secondNumberAsString = inputValues.substring(indexOperator + 1);

        int firstNumber;
        int secondNumber;

        boolean firstRomanNumber = romanNumbersService.checkRomanNumber(firstNumberAsString);
        boolean secondRomanNumber = romanNumbersService.checkRomanNumber(secondNumberAsString);

        if (firstRomanNumber && !secondRomanNumber) {
            throw new Exception("Второе число не римское!");
        }
        if (!firstRomanNumber && secondRomanNumber) {
            throw new Exception("Первое число не римское!");
        }
        if (firstRomanNumber) {
            firstNumber = romanNumbersService.romanConvert(firstNumberAsString);
            secondNumber = romanNumbersService.romanConvert(secondNumberAsString);

        } else {
            firstNumber = Integer.parseInt(firstNumberAsString);
            secondNumber = Integer.parseInt(secondNumberAsString);
        }

        return new ParseResult(firstNumber, secondNumber, operator);
    }
}
