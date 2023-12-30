import java.util.regex.*;

public class Hyperlinks {
    public static void main(String[] args) {
        String textWithLinks = "Visit our website https://www.example.com for more information.";
        Pattern linkPattern = Pattern.compile("https?://\\S+");
        Matcher linkMatcher = linkPattern.matcher(textWithLinks);
        String replacedText = linkMatcher.replaceAll("<a href=\"$0\">$0</a>");
        System.out.println("Replaced text: " + replacedText);
    }
}