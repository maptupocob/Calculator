import Exceptions.RomanianHasNoZeroException;

import java.util.Arrays;

public class Converter {
    private final static String[] ROMANIAN_DIGITS = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

    public static boolean isRomanianNumber(String number) {
        return Arrays.asList(ROMANIAN_DIGITS).contains(number);
    }

    public static boolean isCorrectArabianNumber(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int convertRomanToArab(String romanNumber) {
        return Arrays.asList(ROMANIAN_DIGITS).indexOf(romanNumber) + 1;
    }

    public static String convertArabToRoman(int number) throws RomanianHasNoZeroException {
        if (number == 0) {throw new RomanianHasNoZeroException();}
        StringBuilder res = new StringBuilder();
        int tempNumber = number;
        int hundreds = tempNumber / 100;
        for (int i = 0; i < hundreds; i++) {
            res.append("C");
        }
        tempNumber = number % 100;
        int fifties = tempNumber / 50;
        for (int i = 0; i < fifties; i++) {
            res.append("L");
        }
        tempNumber = number % 50;
        int tens = tempNumber / 10;
        for (int i = 0; i < tens; i++) {
            res.append("X");
        }
        tempNumber = tempNumber % 10;
        int fives = tempNumber / 5;
        for (int i = 0; i < fives; i++) {
            res.append("V");
        }
        tempNumber = tempNumber % 5;
        int ones = tempNumber;
        for (int i = 0; i < ones; i++) {
            res.append("I");
        }
        res = new StringBuilder(res.toString().replace("LXXXX", "XC")
                .replace("XXXX", "XL")
                .replace("VIIII", "IX")
                .replace("IIII", "IV"));

        return res.toString();
    }
}
