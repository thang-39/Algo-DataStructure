package CodeWars;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringIncrementer {

    //Examples:
    //foo -> foo1
    //foobar23 -> foobar24
    //foo0042 -> foo0043
    //foo9 -> foo10
    //foo099 -> foo100

    public static void main(String[] args) {
        System.out.println(incrementString("foobar23"));
        System.out.println(incrementString("foo0042"));
        System.out.println(incrementString("foo099"));
        System.out.println(incrementString("foo9"));
        System.out.println(incrementString("foo"));
    }


    public static String incrementString(String str) {
        Pattern regex = Pattern.compile("[^\\d](\\d+)");
        Matcher matcher = regex.matcher(str);
        if (matcher.find()) {
            String num = matcher.group(1);
            System.out.println("len: " + num.length());

            int num1 = Integer.parseInt(num) + 1;

            if (Integer.toString(Integer.parseInt(num)).length() == Integer.toString(num1).length()) {
                return str.replace(Integer.toString(Integer.parseInt(num)),Integer.toString(num1));
            }

            if ( Integer.toString(Integer.parseInt(num)).length() < Integer.toString(num1).length() && Integer.toString(Integer.parseInt(num)).length() > 1 ) {
                return str.replace( "0" + Integer.toString(Integer.parseInt(num)),Integer.toString(num1));
            }

            if ( Integer.toString(Integer.parseInt(num)).length() < Integer.toString(num1).length() && Integer.toString(Integer.parseInt(num)).length() == 1 ) {
                return str.replace(Integer.toString(Integer.parseInt(num)),Integer.toString(num1));
            }
        } else {
            return str + "1";
        }

        return "end"; // you code here
    }
}
