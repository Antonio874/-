import java.util.*;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static String nonRepeatable(String s) {
        if (s.length() == 0) {
            return "";
        } else if (s.substring(0, s.length() - 1).contains(s.substring(s.length() - 1, s.length()))) {
            return nonRepeatable(s.substring(0, s.length() - 1));
        } else {
            return nonRepeatable(s.substring(0, s.length() - 1)) + s.substring(s.length() - 1, s.length());
        }
    }
    public static List<String> generateBrackets(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            result.add("");
        }
        else if (n == 1) {
            result.add("()");
        }
        else {
            for (int i = 0; i < n; i++) {
                for (String left : generateBrackets(i)) {
                    for (String right : generateBrackets(n - i - 1)) {
                        result.add("(" + left + ")" + right);
                    }
                }
            }
        }
        return result;
    }
    public static List<String> binarySystem(int n) {
        if (n == 1) {
            List<String> result = new ArrayList<>();
            result.add("0");
            result.add("1");
            return result;
        } else {
            List<String> prev = binarySystem(n-1);
            List<String> result = new ArrayList<>();
            for (String s : prev) {
                result.add(s + "0");
                result.add(s + "1");
            }
            return result;
        }
    }

    public static List<String> noAdjacentOnesAndZeros(int n) {
        List<String> result = new ArrayList<>();
        for (String s : binarySystem(n)) {
            if (!s.contains("00")) {
                result.add(s);
            }
        }
        return result;
    }
    public static String alphabeticRow(String s) {
        int max_len = 0;
        int curr_len = 1;
        String row = s.substring(0, 1);
        String longest_row = "";
        for (int i = 1; i < s.length(); i++) {
            if ((int)s.charAt(i) == (int)s.charAt(i-1) + 1 || (int)s.charAt(i) == (int)s.charAt(i-1) - 1) {
                curr_len++;
                row += s.charAt(i);
            } else {
                if (curr_len > max_len) {
                    max_len = curr_len;
                    longest_row = row;
                }
                curr_len = 1;
                row = s.substring(i, i+1);
            }
        }
        if (curr_len > max_len) {
            longest_row = row;
        }
        return longest_row;
    }
    public static String countAndSort(String s) {
        String [] elements = new String[s.length()];
        for(int i = 0; i < elements.length; i++){
            elements[i] = "";
        }
        int countInt = 0;
        String result = "";
        for(int i = 0; i < s.length()-1; i++){
            countInt+=1;
            if(s.charAt(i) != s.charAt(i+1)) {
                elements[countInt] += s.charAt(i);
                countInt = 0;
            }
        }
        elements[countInt + 1] += s.charAt(s.length()-1);
        for(int i = 0; i < elements.length; i++){
            for(char c : elements[i].toCharArray()){
                result += c + String.valueOf(i);
            }
        }
        return result;
    }
    public static int convertToNum(String str){
        int result = 0;
        String [] num = {"one", "tw", "th", "fo", "fi", "six", "seven", "eight", "nine", "ten", "eleven", "twelve"};
        HashMap <String, Integer> num_hash = new HashMap<>();
        for(int i = 1; i <= num.length; i++){
            num_hash.put(num[i-1], i);
        }
        String [] word = str.split(" ");
        for(int i = 0; i < word.length; i++){
            for(Map.Entry<String, Integer> entry : num_hash.entrySet()){
                if(word[i].contains(entry.getKey())){
                    if(word[i].contains("ty")){
                        result += entry.getValue()*10;
                    }
                    else if(word[i].contains("teen")){
                        result += entry.getValue()+10;
                    }
                    else {
                        result += entry.getValue();
                    }
                }
            }
            if(word[i].equals("hundred")){
                result *= 100;
            }
        }
        return result;
    }
    public static String uniqueSubstring(String s) {
        int start = 0;
        int end = 0;
        int max_length = 0;
        int max_start = 0;
        int max_end = 0;
        List<Character> unique_chars = new ArrayList<>();

        while (end < s.length()) {
            char c = s.charAt(end);
            if (unique_chars.contains(c)) {
                if (end - start > max_length) {
                    max_length = end - start;
                    max_start = start;
                    max_end = end;
                }

                while (s.charAt(start) != c) {
                    unique_chars.remove(start);
                    start++;
                }
                start++;
            }

            unique_chars.add(c);
            end++;
        }

        if (end - start > max_length) {
            max_length = end - start;
            max_start = start;
            max_end = end;
        }

        return s.substring(max_start, max_end);
    }
    public static int shortestWay(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];
        dp[0][0] = grid[0][0];
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[n-1][n-1];
    }
    public static String numericOrder(String input) {
        String[] words = input.split(" ");
        Map<Integer, String> wordMap = new HashMap<>();

        for (String word : words) {
            int index = 0;
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                if (Character.isDigit(c)) {
                    index = Character.getNumericValue(c);
                } else {
                    sb.append(c);
                }
            }
            wordMap.put(index, sb.toString());
        }

        List<String> orderedWords = new ArrayList<>();
        for (int i = 1; i <= wordMap.size(); i++) {
            orderedWords.add(wordMap.get(i));
        }

        return String.join(" ", orderedWords);
    }
    public static int switchNums(int num1, int num2) {
        char[] numArray = String.valueOf(num1).toCharArray();
        char[] num2Array = String.valueOf(num2).toCharArray();
        char[] num1Array = new char[numArray.length];
        Arrays.sort(numArray);
        for (int i = 0; i < numArray.length; i++) {
            num1Array[numArray.length - 1 - i] = numArray[i];
        }
        HashMap<Character, Integer> nam = new HashMap<>();
        for(int i =0; i < num1Array.length; i++){
            nam.put(num1Array[i], 0);
        }
        for (int i = 0; i < num2Array.length; i++) {
            for (int j = 0; j < num1Array.length; j++) {
                if (num1Array[j] > num2Array[i] ) {
                    if (nam.get(num1Array[j]) == 0) {
                        num2Array[i] = num1Array[j];
                        nam.put(num1Array[j],1);
                    }
                }
            }

        }
        return Integer.parseInt(new String(num2Array));
    }

    public static void main(String[] args) {
        System.out.println("------1------");
        System.out.println(nonRepeatable("abracadabra"));
        System.out.println(nonRepeatable("paparazzi"));

        System.out.println("------2------");
        System.out.println(generateBrackets(1));
        System.out.println(generateBrackets(2));
        System.out.println(generateBrackets(3));

        System.out.println("------3------");
        System.out.println(noAdjacentOnesAndZeros(3));
        System.out.println(noAdjacentOnesAndZeros(4));

        System.out.println("------4------");
        System.out.println(alphabeticRow("abcdjuwx"));
        System.out.println(alphabeticRow("klmabzyxw"));

        System.out.println("------5------");
        System.out.println(countAndSort("aaabbcdd"));
        System.out.println(countAndSort("vvvvaajaaaaa"));

        System.out.println("------6------");
        System.out.println(convertToNum("eight"));
        System.out.println(convertToNum("five hundred sixty seven"));
        System.out.println(convertToNum("thirty one"));

        System.out.println("------7------");
        System.out.println(uniqueSubstring("123412324"));
        System.out.println(uniqueSubstring("111111"));
        System.out.println(uniqueSubstring("77897898"));

        System.out.println("------8------");
        int[][] grid1 = {{1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
        System.out.println(shortestWay(grid1));
        int[][] grid2 = {{2, 7, 3},
                {1, 4, 8},
                {4, 5, 9}};
        System.out.println(shortestWay(grid2));

        System.out.println("------9------");
        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));

        System.out.println("------10------");
        System.out.println(switchNums(519, 723));
        System.out.println(switchNums(491, 3912));
        System.out.println(switchNums(6274, 71259));
        }
}