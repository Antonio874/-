import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] arr = new int[length];
    try {
        int sum = 0;
        for (int i = 0; i </** =*/ arr.length; i++) {
            arr[i] = scanner.nextInt();
            sum += arr[i];
        }
        double average = (double) sum / arr.length;
        System.out.println("Среднее арифметическое: " + average);
    }
    catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Error: Индекс массива за пределами допустимого");
    }
    catch (InputMismatchException e) {
        System.out.println("Error: Массив содержит нечисловое значение");
    }
}
}