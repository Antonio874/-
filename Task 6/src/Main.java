import java.util.*;

class CustomMathException extends Exception {
    public CustomMathException(String text) {
        System.out.println(text);
    }
}
public class Main {
    public static String hiddenAnagram(String sentence, String anagram) {
        String cleanedSentence = sentence.replaceAll("[^a-zA-Z]", "").toLowerCase();
        String cleanedAnagram = anagram.replaceAll("[^a-zA-Z]", "").toLowerCase();
        Map<Character, Integer> anagramMap = new HashMap<>();
        for (char c : cleanedAnagram.toCharArray()) {
            if(anagramMap.containsKey(c)){
                anagramMap.put(c, anagramMap.get(c)+1);
            }else{
                anagramMap.put(c, 1);
            }
        }
        int start = 0;
        for(int end = 0; end < cleanedSentence.length(); end++) {
            char c = cleanedSentence.charAt(end);

            if (anagramMap.containsKey(c) && anagramMap.get(c)>0) {
                anagramMap.put(c, anagramMap.get(c)-1);
                boolean flag=true;
                for (char character: anagramMap.keySet()){
                    if(anagramMap.get(character) != 0){
                        flag = false;
                    }
                }
                if (flag) {
                    return cleanedSentence.substring(start, end+1);
                }
            } else {
                if(anagramMap.containsKey(c)){
                    int i = 0;
                    while(true){
                        char b = cleanedSentence.charAt(i);
                        if(c == b){
                            start = i + 1;
                            break;
                        }
                        if (anagramMap.containsKey(b)){
                            anagramMap.put(b, anagramMap.get(b)+1);
                        }
                        i++;
                    }
                }else{
                    start=end+1;
                    anagramMap.clear();
                    for (char ch : cleanedAnagram.toCharArray()) {
                        if(anagramMap.containsKey(ch)){
                            anagramMap.put(ch, anagramMap.get(ch)+1);
                        }else{
                            anagramMap.put(ch, 1);
                        }
                    }
                }
            }
        }
        return "notfound";
    }
    public static String[] collect(String word, int n) {
        String[] result = new String[word.length()/n];
        String str = "";
        for(int i = 0; i < word.length(); i++) {
            str += word.charAt(i);
            if (str.length() == n) {
                result[i / n] = str;
                str = "";
            }
        }
        Arrays.sort(result);
        return result;
    }
    public static String[] collec(String word, int n) {  //для 3тьго задания
        int len = word.length()%n==0? word.length()/n : (word.length()/n)+1;
        String[] result = new String[len];
        String str = "";
        for(int i = 0; i < word.length(); i++) {
            str += word.charAt(i);
            if (str.length() == n) {
                result[i / n] = str;
                str = "";
            }
        }
        if(word.length()%n!=0){
            int count = n-str.length();
            for(int i=0; i<=count;i++){
                str += " ";
            }
            result[len-1] = str;
        }
        return result;
    }
    public static String nicoCipher(String message, String  key){
        char[] key_arr = key.toCharArray();
        Arrays.sort(key_arr);
        int[] key_int = new int[key.length()];
        for(int i = 0; i < key.length(); i++){
            key_int[i] = key.indexOf(key_arr[i]);
            key = key.substring(0, key.indexOf(key_arr[i])) + ' ' + key.substring(key.indexOf(key_arr[i])+1);
        }
        String[] message_arr = collec(message, key.length());
        String result = "";
        for(String str: message_arr){
            for(int i : key_int){
                result += str.charAt(i);
            }
        }
        return result;
    }
    public static int[] twoProduct(int[] nums, int n) {
        ArrayList<Integer> leftNums = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < leftNums.size(); j++) {
                if (leftNums.get(j) * nums[i] == n) {
                    return new int[]{leftNums.get(j), nums[i]};
                }
            }
            leftNums.add(nums[i]);
        }
        return new int[0];
    }
    public static int[] isExact(int number) {
        int dynamicNumber = number;
        if (number == 1) return new int[]{1, 1};
        if (number == 2) return new int[]{2, 2};
        for (int i = 2; i <= number; i++) {
            if (dynamicNumber % i != 0) {
                if (i == 2) {
                    return new int[0];
                }
                else {
                    int[] temp = isExact(number / (i - 1));
                    if (temp.length == 0) {
                        return new int[0];
                    }
                    else {
                        if (i - 1 == temp[1]) {
                            return new int[0];
                        }
                        return new int[]{number, (i-1)};
                    }
                }
            }
            dynamicNumber /= i;
        }
        return new int[0];
    }
    public static String fractions(String num){
        num=num.replaceAll("\\(", " ").replaceAll("\\)"," ").replaceAll("\\.", " ");
        String[] num_arr = num.split(" ");
        int chisl = Integer.parseInt(num_arr[0]+num_arr[1]+num_arr[2])-Integer.parseInt(num_arr[0]+num_arr[1]);
        int znam = pow(10, (num_arr[1]+num_arr[2]).length())-pow(10, (num_arr[1]).length());
        int dell = gcd(chisl, znam);
        return (chisl/dell)+"/"+(znam/dell);
    }
    public static int gcd(int a, int b){ //наиб общий делитель
        int max, min, otv = 0;
        max = a > b ? a : b;
        min = a < b ? a : b;
        for(int i = min; i != 0; i--){
            if(max % i == 0 && min % i == 0){
                otv = i;
                break;
            }
        }
        return otv;
    }
    public static int pow(int value, int powValue) { //возведение в степень
        int result = 1;
        for (int i = 1; i <= powValue; i++) {
            result = result * value;
        }
        return result;
    }
    public static String pilish_string(String str) {
        if (str.isEmpty()) return "";

        double pi = 3.14159265358979;
        int[] piNums = new int[15];
        int i = 0;
        for (char number: Double.toString(pi).toCharArray()) {
            if (number != '.') {
                piNums[i] = Character.getNumericValue(number);
                i++;
            }
        }

        StringBuilder answer = new StringBuilder();
        int nowSymbols = 0;
        i = 0;
        while (nowSymbols < str.length()) {
            if (i == 15) break;
            if (nowSymbols + piNums[i] > str.length()) {
                answer.append(str, nowSymbols, str.length());
            }
            else {
                answer.append(str, nowSymbols, nowSymbols + piNums[i]);
            }
            nowSymbols += piNums[i];
            i++;
            if (nowSymbols < str.length()) answer.append(" ");
        }
        if (nowSymbols > str.length()) {
            while (nowSymbols != str.length()) {
                answer.append(str.substring(str.length() - 1));
                nowSymbols -= 1;
            }
        }
        return answer.toString();
    }

        public static String generateNonconsecutive(String str) {

            if (str.isEmpty()) {
                return "Вы ничего не ввели";
            }

            str = str.replaceAll("\\(", " ( ").replaceAll("\\)", " ) ");
            String[] array = str.split(" ");
            ArrayList<String> list = new ArrayList<>(Arrays.asList(array));

            while (list.contains("")) {
                list.remove("");
            }

            evaluateExpression(list);

            return String.valueOf(list.get(0));
        }

        private static ArrayList<String> evaluateExpression(ArrayList<String> list) {

            while (list.contains("(")) {
                int openIndex = list.lastIndexOf("(");
                int closeIndex = 0;
                for (int i = openIndex + 1; i < list.size(); i++) {
                    if (list.get(i).equals(")")) {
                        closeIndex = i;
                        break;
                    }
                }

                ArrayList<String> subList = new ArrayList<>(list.subList(openIndex + 1, closeIndex));

                String result = evaluateExpression(subList).get(0);

                if (result.equals("На ноль делить нельзя")) {
                    list.clear();
                    list.add("На ноль делить нельзя");
                    return list;
                }

                replaceSubListToResult(list, result, openIndex, closeIndex);

            }

            evaluateOperation(list, "*");
            evaluateOperation(list, "/");
            evaluateOperation(list, "+");
            evaluateOperation(list, "-");

            return list;
        }

        private static void replaceSubListToResult(ArrayList<String> list, String replaceStr, int firstInd, int lastInd) {
            list.subList(firstInd, lastInd + 1).clear();
            list.add(firstInd, replaceStr);
        }

        private static void evaluateOperation(ArrayList<String> list, String operator) {

            while (list.contains(operator)) {
                int index = list.indexOf(operator);

                if (operator.equals("-") && (index == 0 || list.get(index - 1).equals("("))) {
                    double operand = Double.parseDouble(list.get(index + 1));
                    double result = -operand;
                    list.remove(index);
                    list.remove(index);
                    list.add(index, String.valueOf(result));

                } else {
                    double first = Double.parseDouble(list.get(index - 1));
                    double second = Double.parseDouble(list.get(index + 1));
                    double result = 0;

                    switch (operator) {
                        case "*":
                            result = first * second;
                            break;
                        case "/":
                            if (second != 0) {
                                result = first / second;
                            } else {
                                list.clear();
                                list.add("На ноль делить нельзя");
                                return;
                            }

                            break;
                        case "+":
                            result = first + second;
                            break;
                        case "-":
                            result = first - second;
                            break;
                    }

                    replaceSubListToResult(list, String.valueOf(result), index - 1, index + 1);
                }
            }
        }

    public static String isValid(String str) {
        Map<Character, Integer> dictionary = new HashMap<>();
        int unique = 0;
        for (char symbol: str.toCharArray()) {
            if (dictionary.containsKey(symbol)) {
                dictionary.put(symbol, dictionary.get(symbol) + 1);
            }
            else {
                dictionary.put(symbol, 1);
                unique += 1;
            }
        }

        int[] values = new int[unique];
        int i = 0;
        for(int value: dictionary.values()) {
            values[i] = value;
            i++;
        }

        Arrays.sort(values);
        if (values[0] == values[values.length - 1]) {
            return "YES";
        }
        else if (values[1] == values[values.length - 1] && values[0] == 1) {
            return "YES";
        }
        else if (values[0] == values[values.length - 2] && values[values.length - 1] - 1 == values[0]) {
            return "YES";
        }
        return "NO";
    }

    public static String findLCS(String str1, String str2) {
        int[][] matrix = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {
                if (i == 0 || j == 0) {
                    matrix[i][j] = 0;
                }
                else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                }
                else {
                    matrix[i][j] = Math.max(matrix[i][j - 1], matrix[i - 1][j]);
                }
            }
        }
        ArrayList<Character> chars = new ArrayList<>();
        int temp_i = str1.length() - 1;
        int temp_j = str2.length() - 1;
        while (temp_i >= 0 && temp_j >= 0) {
            if (str1.charAt(temp_i) == str2.charAt(temp_j)) {
                chars.add(str1.charAt(temp_i));
                temp_i -= 1;
                temp_j -= 1;
            }
            else if (matrix[temp_i][temp_j + 1] >= matrix[temp_i + 1][temp_j]) {
                temp_i -= 1;
            }
            else {
                temp_j -= 1;
            }
        }
        Collections.reverse(chars);
        StringBuilder answer = new StringBuilder();
        for (char c: chars) {
            answer.append(c);
        }
        return answer.toString();
    }
    public static void main(String[] args) {
        System.out.println("----------1------------");
        System.out.println(hiddenAnagram("My world evolves in a beautiful space called Tesh.", "sworn love lived"));
        System.out.println(hiddenAnagram("An old west action hero actor", "Clint Eastwood"));
        System.out.println(hiddenAnagram("Mr. Mojo Rising could be a song title", "Jim Morrison"));
        System.out.println(hiddenAnagram("Banana? margaritas", "ANAGRAM"));
        System.out.println(hiddenAnagram("D  e b90it->?$ (c)a r...d,,#~", "bad credit"));
        System.out.println(hiddenAnagram("Bright is the moon", "Bongo mirth"));
        System.out.println("----------2------------");
        System.out.println(Arrays.toString(collect("intercontinentalisationalism", 6)));
        System.out.println(Arrays.toString(collect("strengths", 3)));
        System.out.println(Arrays.toString(collect("pneumonoultramicroscopicsilicovolcanoconiosis", 15)));
        System.out.println("----------3------------");
        System.out.println( nicoCipher("myworldevolvesinhers", "tesh"));
        System.out.println( nicoCipher("andiloveherso", "tesha"));
        System.out.println( nicoCipher("mubashirhassan", "crazy"));
        System.out.println( nicoCipher("edabitisamazing", "matt"));
        System.out.println( nicoCipher("iloveher", "612345"));
        System.out.println("----------4------------");
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 9, 4, 5, 15}, 45)));
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 9, 4, 15, 3, 5}, 45)));
        System.out.println(Arrays.toString(twoProduct(new int[]{1,  2, -1,  4,  5,  6,  10, 7}, 20)));
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 4, 5,  6, 7, 8, 9, 10}, 10)));
        System.out.println(Arrays.toString(twoProduct(new int[]{100, 12, 4, 1, 2}, 15)));
        System.out.println("----------5------------");
        System.out.println(Arrays.toString(isExact(6) ));
        System.out.println(Arrays.toString(isExact(24) ));
        System.out.println(Arrays.toString(isExact(125) ));
        System.out.println(Arrays.toString(isExact(720) ));
        System.out.println(Arrays.toString(isExact(1024) ));
        System.out.println(Arrays.toString(isExact(40320) ));
        System.out.println("----------6------------");
        System.out.println(fractions("0.(6)"));
        System.out.println(fractions("1.(1)") );
        System.out.println(fractions("3.(142857)") );
        System.out.println(fractions("0.19(2367)") );
        System.out.println(fractions("0.1097(3)") );
        System.out.println("----------7------------");
        System.out.println(pilish_string("33314444"));
        System.out.println(pilish_string("TOP"));
        System.out.println(pilish_string("X"));
        System.out.println(pilish_string(""));
        System.out.println(pilish_string("CANIMAKEAGUESSNOW"));
        System.out.println(pilish_string("FORALOOP"));
        System.out.println(pilish_string("HOWINEEDADRINKALCOHOLICINNATUREAFTERTHEHEAVYLECTURESINVOLVINGQUANTUMMECHANICSANDALLTHESECRETSOFTHEUNIVERSE"));
        System.out.println("----------8------------");
        try {
            System.out.println(generateNonconsecutive("13 / 4"));
            System.out.println(generateNonconsecutive("-(-5 - 4)"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("----------9------------");
        System.out.println(isValid("abcba"));
        System.out.println(isValid("aabbccddeefghi"));
        System.out.println(isValid("abcdefghhgfedecba"));
        System.out.println("----------10------------");
        System.out.println(findLCS("abcd", "bd"));
        System.out.println(findLCS("aggtab", "gxtxamb") );
    }
}