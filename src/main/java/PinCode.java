import java.util.InputMismatchException;
import java.util.Scanner;

public class PinCode {
    public static void main(String[] args) {
        String[] pins = {"1234", "2345", "3456", "4567"};
        getPinCode(pins);
    }
    public static void getPinCode(String[] pins) throws ArrayIndexOutOfBoundsException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер ячейки от 0 до 3 для получения пин-кода: ");
        try{
            int index = scanner.nextInt();
            System.out.println(String.format("Пин-код из ячейки %d: %s", index, pins[index]));
        } catch (ArrayIndexOutOfBoundsException indexException) {
            System.out.println("Номер ячейки выходит за пределы интервала от 0 до 3");
            throw indexException;
        } catch (InputMismatchException inputException) {
            System.out.println("Неправильно введен номер ячейки. Введите число от 0 до 3");
            throw inputException;
        }

    }
}