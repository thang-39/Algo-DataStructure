package hackerRank;

import java.util.Map;

public class TimeConversion {
    public static void main(String[] args) {
        String s = "12:01:00AM";
        System.out.println(s.substring(0,2));
    }

    public static String timeConversion(String s) {
        // Write your code here



        String s1 = s.substring(0, s.length()-2);


        if (s.endsWith("AM")) {
            if (s.startsWith("12")) {
                return "00" + s.substring(2, s.length()-2);
            }
            return s1;
        }

        if (s.endsWith("PM")) {
            if (s.startsWith("12")) {
                return s1;
            }
            return (Integer.parseInt(s.substring(0,2)) + 12) + s.substring(2, s.length()-2);
        }
        return s;

    }

}
