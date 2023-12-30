import java.util.regex.*;

public class IP_Address {
    public static void main(String[] args) {
        String ipAddress = "134.167.33.0"; //0-255
        Pattern ipPattern = Pattern.compile("^((\\d{1,2}|1\\d{2}|2[0-4]\\d|25[0-5])\\.){3}(\\d{1,2}|1\\d{2}|2[0-4]\\d|25[0-5])$");
        Matcher ipMatcher = ipPattern.matcher(ipAddress);
        if (ipMatcher.matches()) {
            System.out.println("IP Address is valid");
        } else {
            System.out.println("IP Address is invalid");
        }
    }
}