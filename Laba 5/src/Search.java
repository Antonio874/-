import java.util.regex.*;

public class Search {
    public static void main(String[] args) {
        String textToSearch = "The quick brown fox jumps over the lazy dog";
        String startingLetter = "t";
        Pattern wordPattern = Pattern.compile("\\b" + startingLetter + "\\w*\\b", Pattern.CASE_INSENSITIVE);
        Matcher wordMatcher = wordPattern.matcher(textToSearch);
        System.out.println("Words starting with '" + startingLetter + "': ");
        while (wordMatcher.find()) {
            System.out.println(wordMatcher.group());
        }
    }
}