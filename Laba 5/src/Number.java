import java.util.regex.*;

public class Number {
    public static void main(String[] args) {
        String text = "The price of the product is $3.34875";
        Pattern pattern = Pattern.compile("((-?)\\d+\\.\\d+)|(-?)(\\d)");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}