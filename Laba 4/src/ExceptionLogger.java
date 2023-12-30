import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ExceptionLogger {
    public static void logException(Exception e) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("exception.log", true))) {
            writer.println("Exception message: " + e.getMessage());
            writer.println("Stack trace: ");
            e.printStackTrace(writer);
            writer.println("----------------------------------------");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}