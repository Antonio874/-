import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixProcessing {
    private static int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
    };
    public static List<Integer> max = new ArrayList<>();
    private static class RowProcessor extends Thread {
        private int[] row;

        public RowProcessor(int[] row) {
            this.row = row;
        }

        @Override
        public void run() {
            int maxElement = Integer.MIN_VALUE;
            for (int value : row) {
                if (value > maxElement) {
                    maxElement = value;
                }
            }
            max.add(maxElement);
            System.out.println("Максимальный элемент в строке " + Arrays.toString(row) + " равен " + maxElement);
        }
    }

    public static void main(String[] args) {
        for (int[] row : matrix) {
            Thread thread = new RowProcessor(row);
            thread.start();
        }

        for (int[] row : matrix) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int maxElement = Integer.MIN_VALUE;
        for (int value : max) {
            if (value > maxElement) {
                maxElement = value;
            }
        }
        System.out.println("Наибольший элемент в матрице равен " + maxElement);
    }
}