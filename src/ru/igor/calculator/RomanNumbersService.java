package ru.igor.calculator;

import java.util.ArrayList;
import java.util.List;

public class RomanNumbersService {
    public String[] romanNumbers = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII",
            "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII",
            "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV",
            "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV",
            "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII",
            "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX",
            "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};


    public boolean checkRomanNumber(String number) {
        for (int i = 0; i < romanNumbers.length; i++) {
            String romanValue = romanNumbers[i];
            if (romanValue.equals(number)) {
                return true;
            }
        }
        return false;
    }


    public int romanConvert(String romanNumber) throws Exception {
        for (int i = 0; i < romanNumbers.length; i++) {
            String romanValue = romanNumbers[i];
            if (romanValue.equals(romanNumber)) {
                return i + 1;
            }
        }
        throw new Exception("Число не римское!");
    }


    public String intToRoman(int arabianNumber) throws Exception {
        for (int i = 0; i <= arabianNumber; i++) {
            if (i == arabianNumber) {
                return romanNumbers[i - 1];
            }
        }
        throw new Exception("Результат невозможен! В Римских числа не существует \"нуля\"!");
    }


    public boolean romanInputValidator(String inputRomanValue) {
        List<String> romanValue = new ArrayList<>();
        for (int i = 0; i < inputRomanValue.length(); i++) {
            String value = inputRomanValue.substring(0, 1);
            romanValue.add(value);
        }
        for (String value : romanValue) {
            for (String romanNumber : romanNumbers) {
                if (value.equals(romanNumber)) {
                    return true;
                }
            }
        }
        return false;
    }
}
