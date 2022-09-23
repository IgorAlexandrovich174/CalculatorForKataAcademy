package ru.igor.calculator;

public class ParseResult {
    private Integer firstNumber;
    private Integer secondNumber;
    private String operator;


    public ParseResult(Integer firstNumber, Integer secondNumber, String operator) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operator = operator;
    }

    public Integer getFirstNumber() {
        return firstNumber;
    }

    public Integer getSecondNumber() {
        return secondNumber;
    }

    public String getOperator() {
        return operator;
    }
}
