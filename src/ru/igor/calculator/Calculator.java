package ru.igor.calculator;

import java.util.Locale;
import java.util.Scanner;

public class Calculator {
    private final InputParser inputParser;
    private final NumbersValidator numbersValidator;
    private final NumbersProcessor numbersProcessor;

    public Calculator(InputParser inputParser,
                      NumbersValidator numbersValidator,
                      NumbersProcessor numbersProcessor) {
        this.inputParser = inputParser;
        this.numbersValidator = numbersValidator;
        this.numbersProcessor = numbersProcessor;
    }

    public void calculation() throws Exception {
        int result = 0;
        RomanNumbersService romanNumbersService = new RomanNumbersService();
        String inputValue = enterData();
        ParseResult parseResult = inputParser.parseStr(inputValue);
        numbersValidator.validate(parseResult);
        result = numbersProcessor.processNumbers(parseResult);
        boolean resultValidator = romanNumbersService.romanInputValidator(inputValue);
        if (resultValidator) {
            System.out.println(romanNumbersService.intToRoman(result));
        } else {
            System.out.println(result);
        }

    }


    private static String enterData() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Вводите: ");
            return input.nextLine().toUpperCase(Locale.ROOT).replaceAll("\\s+", "");
        }
    }

    public static void main(String[] args) throws Exception {

        RomanNumbersService romanNumbersService = new RomanNumbersService();
        InputParser inputParser = new InputParser(romanNumbersService);

        NumbersValidator numbersValidator = new NumbersValidator();
        NumbersProcessor numbersProcessor = new NumbersProcessor();

        Calculator calculator = new Calculator(inputParser, numbersValidator, numbersProcessor);
        calculator.calculation();

    }
}
