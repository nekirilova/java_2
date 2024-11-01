import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        final String CALCULATOR_START_TIP = "Этот калькулятор делит только целые числа. Введите делимое: ";
        final String CALCULATOR_CONTINUE_TIP = "Введите делитель: ";

        Scanner scanner = new Scanner(System.in);
        int dividend = readInt(scanner, CALCULATOR_START_TIP);
        int divisor = readInt(scanner, CALCULATOR_CONTINUE_TIP);
        countResult(scanner, dividend, divisor);
    }

    public static int readInt(Scanner scanner, String inputTip) {
        System.out.println(inputTip);
        int input;
        try {
            input = scanner.nextInt();
        } catch (InputMismatchException notIntException) {
            System.out.println("Кажется, вы ввели не целое число");
            throw notIntException;
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("Вы так ничего и не ввели");
            throw noSuchElementException;
        }
        return input;
    }

    public static void countResult(Scanner scanner, int dividend, int divisor) {
        try {
            int result = dividend / divisor;
            System.out.println("Максимально близкий целочисленный ответ: " + result);
        } catch (ArithmeticException zeroException) {
            System.out.println("На ноль делить нельзя. Все сломалось((");
            throw zeroException;
        } catch (Exception e) {
            System.out.println("Что-то пошло не по плану... Калькулятор отключается");
            throw e;
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
