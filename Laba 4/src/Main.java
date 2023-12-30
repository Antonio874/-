public class Main {
    public static void main(String[] args) {
        int age = 30;
        try {
            if (age < 0 || age > 120) {
                throw new CustomAgeException("Недопустимый возраст: " + age);
            }
            System.out.println("Допустимый возраст: " + age);
        } catch (CustomAgeException e) {
            ExceptionLogger.logException(e);
        }
    }
}
