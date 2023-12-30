import java.lang.Math;
import java.util.*;

public class Main {
    public static boolean sameLetterPattern(String str1, String str2) {
        if(str1.length() != str2.length()){
            return false;
        }
        int[] int1 = new int[str1.length()];
        for(int i = 0; i < str1.length(); i++){
            int1[i] = str1.charAt(i);
        }
        int[] int2 = new int[str2.length()];
        for(int i = 0; i < str2.length(); i++){
            int2[i] = str2.charAt(i);
        }
        int diff = int1[0] - int2[0];
        for(int i = 0; i < str1.length(); i++){
            if(int1[i] - int2[i] != diff){
                return false;
            }
        }
        return true;
    }
    public static char getSymbol(int a){
        if(a >= 0 && a < 8){
            return (char) (a + 65);
        }else if(a >= 8){
            return (char) ((a - 8) + 65);
        }else{
            return (char) ((8 + a) + 65);
        }
    }

    public static String spiderVsFly(String sp, String fl){
        char sp_ch = sp.charAt(0);
        char fl_ch = fl.charAt(0);
        int sp_int = sp.charAt(1) - 48;
        int fl_int = fl.charAt(1) - 48;
        int dif;
        if(Math.abs(sp_ch - fl_ch) > 4){
            dif= 8 - Math.abs(sp_ch - fl_ch);
        }else {
            dif = Math.abs(sp_ch - fl_ch);
        }
        boolean dir = fl_ch == getSymbol(sp_ch - 65 - dif);
        String result = sp;
        if (sp_int == 0){
            for(int i = 1;i <= fl_int; i++){
                result += "-" + fl.charAt(0) + (char) (i + 48);
            }
        } else if(sp_int >= fl_int){
            if(fl_int*2 <= dif*Math.sqrt((fl_int*fl_int*2)-(2*fl_int*fl_int*Math.cos(3.141593/4)))){
                for(int i = sp_int - 1; i != 0; i--){
                    result += "-" + sp_ch + (char) (i + 48);
                }
                result += "-A0";
                for(int i = 1;i <= fl_int; i++){
                    result += "-" + fl_ch + (char) (i + 48);
                }
            }else{
                if(dir) {
                    for (int i = sp_int - 1; i >= fl_int; i--) {
                        result += "-" + sp_ch + (char) (i + 48);
                    }
                    for (int i = 1; i <= dif; i++) {
                        result += "-" + getSymbol(sp_ch - 65 - i) + fl.charAt(1);
                    }
                }else {
                    for (int i = sp_int - 1; i >= fl_int; i--) {
                        result += "-" + sp.charAt(0) + (char) (i + 48);
                    }
                    for (int i = 1; i <= dif; i++) {
                        result += "-" + getSymbol(sp_ch - 65 + i) + fl.charAt(1);
                    }
                }
            }
        }else{
            if(2*sp_int <= dif*Math.sqrt((sp_int*sp_int*2)-(2*sp_int*sp_int*Math.cos(3.141593/4)))){
                for(int i = sp_int; i != 0; i--){
                    result += "-" + sp.charAt(0) + (char) (i + 48);
                }
                result += "-A0";
                for(int i = 1;i <= fl_int; i++){
                    result += "-" + fl.charAt(0) + (char) (i + 48);
                }
            }else{
                if(dir){
                    for (int i = 1; i <= dif; i++) {
                        result += "-" + getSymbol(sp_ch - 65 - i) + sp.charAt(1);
                    }
                    for (int i = sp_int + 1; i <= fl_int; i++) {
                        result += "-" + fl_ch + (char) (i + 48);
                    }
                }else {
                    for (int i = 1; i <= dif; i++) {
                        result += "-" + getSymbol(sp_ch - 65 + i) + sp.charAt(1);
                    }
                    for (int i = sp_int + 1; i <= fl_int; i++) {
                        result += "-" + fl_ch + (char) (i + 48);
                    }
                }
            }
        }
        return result;
    }
    public static int countDigits(long num) {
        if (num < 10) {
            return 1;
        } else {
            return 1 + countDigits(num / 10);
        }
    }
    public static int totalPoints(String[] guessedWords, String decryptedWord) {  //переделать
        int points = 0;
        for (String word : guessedWords) {
            if(containsLetters(word, decryptedWord)){
                if (word.length() == 3) {
                    points += 1;
                } else if (word.length() == 4) {
                    points += 2;
                } else if (word.length() == 5) {
                    points += 3;
                } else if (word.length() == 6) {
                    points += 4;
                }
                if(word.length() == decryptedWord.length()){  //исправление
                    points += 50;
                }
            }
        }
        return points;
    }

    public static boolean containsLetters(String word, String decryptedWord) {
        int[] lettersCount = new int[26];
        for (char c : decryptedWord.toCharArray()) {
            lettersCount[c - 'a']++;
        }
        for (char c : word.toCharArray()) {
            if (lettersCount[c - 'a'] == 0) {
                return false;
            }
            lettersCount[c - 'a']--;
        }
        return true;
    }
    public static int[][] sumsUp(int[] numbers) {                 //переделать
        List<int[]> pairsList = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == 8) {
                    int[] pair = {numbers[i], numbers[j]};
                    Arrays.sort(pair);
                    pairsList.add(pair);
                }
            }
        }
        int[][] pairsArray = new int[pairsList.size()][2];
        for (int i = 0; i < pairsList.size(); i++) {
            pairsArray[i] = pairsList.get(i);
        }
        Arrays.sort(pairsArray, Comparator.comparingInt((int[] a) -> Math.abs(a[0] - a[1])));  //исправлние
        return pairsArray;
    }
    public static String takeDownAverage(String[] classmates) {
        int totalPercentage = 0;
        for (String percentage : classmates) {
            totalPercentage += Integer.parseInt(percentage.replace("%", ""));
        }
        return ((totalPercentage/classmates.length) - 5 * (classmates.length + 1)) + "%";
    }
    public static String caesarCipher(String mode, String message, int shift) {
        if (mode.equals("encode")) {
            return encode(message, shift);
        } else if (mode.equals("decode")) {
            return encode(message, 26 - shift);
        } else {
            return "Invalid mode";
        }
    }
    public static String encode(String message, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                result.append((char) ((c - base + shift) % 26 + (int) 'A'));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
    public static int setSetup(int n, int k){
        return fac(n)/fac(n-k);
    }
    public static int fac(int a){
        if(a == 0){
            return 1;
        }
        return fac(a-1) * a;
    }
    public static String timeDifference(String city1, String firstDate, String city2) {
        String answer = "";
        int time1 = timeZone(city1);
        int time2 = timeZone(city2);
        int deltaTime = time2 - time1;
        int deltaHour = deltaTime / 60;
        int deltaMinute = deltaTime % 60;

        String[] words = firstDate.split(" ");
        int month = monthIndex(words[0]);
        int day = Integer.parseInt(words[1].replace(",", ""));
        int year = Integer.parseInt(words[2]);
        String[] time = words[3].split(":");
        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);

        int newYear = year;
        int newMonth = month;
        int newDay = day;
        int newHour = hour + deltaHour;
        int newMinute = minute + deltaMinute;

        if (newMinute < 0) {
            newMinute += 60;
            newHour -= 1;
        }
        else if (newMinute >= 60) {
            newMinute -= 60;
            newHour += 1;
        }

        if (newHour < 0) {
            newHour += 24;
            newDay -= 1;
        }
        else if (newHour >= 24) {
            newHour -= 24;
            newDay += 1;
        }

        if (newDay == 0) {
            newMonth -= 1;
            if (newMonth == 0) {
                newMonth = 12;
                newYear -= 1;
            }
            newDay = dayInMonth(newMonth, newYear);
        }
        else if (newDay > dayInMonth(newMonth, newYear)) {
            newMonth += 1;
            if (newMonth == 13) {
                newMonth = 1;
                newYear += 1;
            }
            newDay = 1;
        }

        String strMinute;
        if (newMinute < 10) {
            strMinute = "0" + newMinute;
        }
        else {
            strMinute = Integer.toString(newMinute);
        }

        String strHour;
        if (newHour < 10) {
            strHour = "0" + newHour;
        }
        else {
            strHour = Integer.toString(newHour);
        }
        answer = newYear + "-" + newMonth + "-" + newDay + " " + strHour + ":" + strMinute;
        return answer;
    }
    public static int timeZone(String city) {
        int time = 0;
        switch (city) {
            case "Los Angeles" -> time = -8 * 60;
            case "New York" -> time = -5 * 60;
            case "Caracas" -> time = -(4 * 60 + 30);
            case "Buenos Aires" -> time = -3 * 60;
            case "London" -> time = 0;
            case "Rome" -> time = 60;
            case "Moscow" -> time = 3 * 60;
            case "Tehran" -> time = 3 * 60 + 30;
            case "New Delhi" -> time = 5 * 60 + 30;
            case "Beijing" -> time = 8 * 60;
            case "Canberra" -> time = 10 * 60;
        }
        return time;
    }
    public static int monthIndex(String month) {
        int index = 0;
        switch (month) {
            case "January" -> index = 1;
            case "February" -> index = 2;
            case "March" -> index = 3;
            case "April" -> index = 4;
            case "May" -> index = 5;
            case "June" -> index = 6;
            case "July" -> index = 7;
            case "August" -> index = 8;
            case "September" -> index = 9;
            case "October" -> index = 10;
            case "November" -> index = 11;
            case "December" -> index = 12;
        }
        return index;
    }

    public static int dayInMonth(int monthIndex, int year) {
        int days = 0;
        switch (monthIndex) {
            case 1, 3, 5, 7, 8, 10, 12 -> days = 31;
            case 4, 6, 9, 11 -> days = 30;
            case 2 -> {
                if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                    days = 29;
                }
                else {
                    days = 28;
                }
            }
        }
        return days;
    }
    public static boolean isNew(int num){        //переделать
        String num_str = String.valueOf(num);
        StringBuilder sb = new StringBuilder();
        sb.append(num_str.charAt(0));
        boolean secondDigitPassed = false;
        for (int i = 1; i < num_str.length(); i++) {
            if (!secondDigitPassed && num_str.charAt(i) == '0') {   //исправление
                continue;
            }
            sb.append(num_str.charAt(i));
            if (!secondDigitPassed) {
                secondDigitPassed = true;
            }
        }
        if((sb.toString()).contains("0")){
            return false;
        }
        Integer[] digits = new Integer[sb.length()];
        int save = Integer.parseInt(sb.toString());
        int num_int = Integer.parseInt(sb.toString());
        int j = 0;
        while(num_int !=0 ){
            digits[j] = num_int % 10;
            num_int = num_int / 10;
            j++;
        }
        Arrays.sort(digits, Collections.reverseOrder());
        int newNum = 0;
        for(int i = 0; i < digits.length; i++){
            newNum += digits[i]*pow(10, i);
        }
        return save == newNum;
    }
    public static int pow(int value, int powValue) {
        int result = 1;
        for (int i = 1; i <= powValue; i++) {
            result = result * value;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("---------1----------");
        System.out.println(sameLetterPattern("ABAB", "CDCD"));
        System.out.println(sameLetterPattern("ABCBA", "BCDCB"));
        System.out.println(sameLetterPattern("FFGG", "CDCD"));
        System.out.println(sameLetterPattern("FFFF", "ABCD"));
        System.out.println("---------2----------");
        System.out.println(spiderVsFly("G2", "A2") );
        System.out.println(spiderVsFly("A1", "G1") );
        System.out.println(spiderVsFly("A4", "H2") );
        System.out.println("------------3--------------");
        System.out.println(countDigits(4666));
        System.out.println(countDigits(544));
        System.out.println(countDigits(121317));
        System.out.println(countDigits(0));
        System.out.println(countDigits(12345));
        System.out.println(countDigits(1289396387328L));
        System.out.println("------------4--------------");
        System.out.println(totalPoints(new String[]{"cat", "create", "sat"}, "caster"));
        System.out.println(totalPoints(new String[]{"trance", "recant"}, "recant"));
        System.out.println(totalPoints(new String[]{"dote", "dotes", "toes", "set", "dot", "dots", "sted"}, "tossed"));
        System.out.println("------------5--------------");
        int[] a5 = {1, 2, 3, 4, 5};
        System.out.println(Arrays.deepToString(sumsUp(a5)));
        int[] a6 = {1, 2, 3, 7, 9};
        System.out.println(Arrays.deepToString(sumsUp(a6)));
        int[] a7 = {10, 9, 7, 2, 8};
        System.out.println(Arrays.deepToString(sumsUp(a7)));
        int[] a8 = {1, 6, 5, 4, 8, 2, 3, 7};
        System.out.println(Arrays.deepToString(sumsUp(a8)));
        System.out.println();
        System.out.println("------------6--------------");
        System.out.println(takeDownAverage(new String[]{"95%", "83%", "90%", "87%", "88%", "93%"}));
        System.out.println(takeDownAverage(new String[]{"10%"}));
        System.out.println(takeDownAverage(new String[]{"53%", "79%"}));
        System.out.println("------------7--------------");
        System.out.println(caesarCipher("encode", "hello world", 3));
        System.out.println(caesarCipher("decode", "almost last task!", 4));
        System.out.println("------------8--------------");
        System.out.println(setSetup(5, 3));
        System.out.println(setSetup(7, 3));
        System.out.println("------------9--------------");
        System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome"));
        System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing"));
        System.out.println("------------10--------------");
        System.out.println(isNew(3));
        System.out.println(isNew(30));
        System.out.println(isNew(321));
        System.out.println(isNew(123));
    }
}
