import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Calculator {

    private static final Map<String, Integer> romanToArabic = new HashMap<>();
    private static final Map<Integer, String> arabicToRoman = new HashMap<>();

    static {
        romanToArabic.put("I", 1);
        romanToArabic.put("II", 2);
        romanToArabic.put("III", 3);
        romanToArabic.put("IV", 4);
        romanToArabic.put("V", 5);
        romanToArabic.put("VI", 6);
        romanToArabic.put("VII", 7);
        romanToArabic.put("VIII", 8);
        romanToArabic.put("IX", 9);
        romanToArabic.put("X", 10);

        arabicToRoman.put(1, "I");
        arabicToRoman.put(2, "II");
        arabicToRoman.put(3, "III");
        arabicToRoman.put(4, "IV");
        arabicToRoman.put(5, "V");
        arabicToRoman.put(6, "VI");
        arabicToRoman.put(7, "VII");
        arabicToRoman.put(8, "VIII");
        arabicToRoman.put(9, "IX");
        arabicToRoman.put(10, "X");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите первое число: ");
            String input1 = scanner.next();

            System.out.print("Введите второе число: ");
            String input2 = scanner.next();

            System.out.print("Введите операцию (+, -, *, /): ");
            String operation = scanner.next();

            int num1, num2;
            boolean isRoman = false;

            if (romanToArabic.containsKey(input1) && romanToArabic.containsKey(input2)) {
                isRoman = true;
                num1 = romanToArabic.get(input1);
                num2 = romanToArabic.get(input2);
            } else {
                num1 = Integer.parseInt(input1);
                num2 = Integer.parseInt(input2);
            }

            if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
                throw new IllegalArgumentException("Числа должны быть от 1 до 10 включительно.");
            }

            int result;

            switch (operation) {
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
                    if (num2 == 0) {
                        throw new ArithmeticException("Деление на ноль невозможно.");
                    }
                    result = num1 / num2;
                    break;
                default:
                    throw new IllegalArgumentException("Неверная операция. Используйте +, -, *, /.");
            }

            if (isRoman) {
                System.out.println("Результат: " + arabicToRoman.get(result));
            } else {
                System.out.println("Результат: " + result);
            }

        } catch (NumberFormatException e) {
            System.err.println("Ошибка: Введены некорректные числа.");
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
