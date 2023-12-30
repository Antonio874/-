public class MultiThreadedSum {
    private static int[] array = {2, 3, 4};
    private static int result1, result2, totalResult;

    public static void main(String[] args) {
        // Создаем и запускаем первый поток, который будет суммировать первую половину массива
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < array.length / 2; i++) {
                result1 += array[i];
            }
        });

        // Создаем и запускаем второй поток, который будет суммировать вторую половину массива
        Thread thread2 = new Thread(() -> {
            for (int i = array.length / 2; i < array.length; i++) {
                result2 += array[i];
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Складываем результаты из обоих потоков
        totalResult = result1 + result2;

        System.out.println("Total sum: " + totalResult);
    }
}