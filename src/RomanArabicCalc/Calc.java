package RomanArabicCalc;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Calc {
    static Scanner scanner = new Scanner(System.in);
    static int result;
    static int num1;
    static int num2;

    static String sign;


    public static void main(String[] args)  {
        System.out.println("Input:");
        String input = scanner.nextLine();
        String[] splited = input.split(" ");
        try {
            sign = splited[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new InputMismatchException("throws Exception //т.к. строка не является математической операцией");
        }
        if (splited.length != 3) {
            throw new InputMismatchException("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        num1 = convertRomanToNum(splited[0]);
        num2 = convertRomanToNum(splited[2]);
        if ((num1 != num2) && (num1 < 0 | num2 < 0))
        {
            throw new InputMismatchException("throws Exception //т.к. используются одновременно разные системы счисления");
        }
        if ((num1 < 0) && (num2 < 0)) {
            num1 = Integer.parseInt(splited[0]);
            num2 = Integer.parseInt(splited[2]);
            if (num1 < 1 | num1 > 10 | num2 < 1 | num2 > 10)
            {
                throw new InputMismatchException("Какое-то из чисел больше 10 или меньше 1");
            }
            result = calculated(num1, num2, sign);
            System.out.println("Output:");
            System.out.println(result);
        }
        else {
            result = calculated(num1, num2, sign);
            String resultRoman;
            try {
                resultRoman = convertresultToRoman(result);
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new InputMismatchException("throws Exception //т.к. в римской системе нет отрицательных чисел");
            }
            System.out.println("Output:");
            System.out.println(resultRoman.trim());
        }
    }
    private static int convertRomanToNum(String numArabian) {
        if (numArabian.equals("I")) {
            return 1;
        } else if (numArabian.equals("II")) {
            return 2;
        } else if (numArabian.equals("III")) {
            return 3;
        } else if (numArabian.equals("IV")) {
            return 4;
        } else if (numArabian.equals("V")) {
            return 5;
        } else if (numArabian.equals("VI")) {
            return 6;
        } else if (numArabian.equals("VII")) {
            return 7;
        } else if (numArabian.equals("VIII")) {
            return 8;
        } else if (numArabian.equals("IX")) {
            return 9;
        } else if (numArabian.equals("X")) {
            return 10;
        }
        else {
            return -1;
        }
    }
    private static int calculated(int num1, int num2, String oper) {
        int result = 0;
        switch (oper) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                throw new InputMismatchException("throws Exception //т.к. строка не является математической операцией");
        }
        return result;
    }
    private static String convertresultToRoman (int res) {
        String[] roman = {
            " ", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"
        };
        String[] calc = {
           " ", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"
        };
        final String s = roman[(res / 10)] + calc[(res % 10)];
        return s;
    }

}











