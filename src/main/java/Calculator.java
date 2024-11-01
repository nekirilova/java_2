import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
            int dividend = readDividend(scanner);
            int divisor = readDivisor(scanner);
            countResult(dividend, divisor);
    }

    public static int readDividend(Scanner scanner) throws InputMismatchException {
        System.out.println("Этот калькулятор делит только целые числа. Введите делимое: ");
        int dividend;
        try {
            dividend = scanner.nextInt();
        } catch (InputMismatchException notIntException) {
            System.out.println("Вы ввели не целое число. Попробуйте число без точки:)");
            throw notIntException;
        }
        return dividend;
    }

    public static int readDivisor(Scanner scanner) throws InputMismatchException {
        int divisor;
        System.out.println("Введите делитель: ");
        try {
            divisor = scanner.nextInt();
            if (divisor == 0) {
                System.out.println("Зря вы ввели ноль, сейчас все сломается! ");
            }
        } catch (InputMismatchException notIntException) {
            System.out.println("Вы ввели не целое число. Попробуйте число без точки:)");
            throw notIntException;
        }
        return divisor;
    }

    public static void countResult(int dividend, int divisor) throws Exception {
        try {
            int result = dividend / divisor;
            System.out.println("Максимально близкий целочисленный ответ: " + result);
        } catch (ArithmeticException zeroException) {
            System.out.println("На ноль делить нельзя. Все сломалось((");
            throw zeroException;
        } catch (Exception e) {
            System.out.println("Что-то пошло не по плану... Калькулятор отключается");
            throw e;
        }
    }
}
