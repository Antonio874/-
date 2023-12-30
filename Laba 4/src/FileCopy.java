import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        String sourceFileName = "vong.txt";
        String destinationFileName = "pinpong.txt";

        try (InputStream inputStream = new FileInputStream(sourceFileName);
             OutputStream outputStream = new FileOutputStream(destinationFileName)) {

            //outputStream.close();
            //inputStream.close();
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            System.out.println("Успешное копирование");
        } catch (IOException e) {
            System.out.println("Ошибка при взаимодействием с файлом: " + e.getMessage());
        }
    }
}