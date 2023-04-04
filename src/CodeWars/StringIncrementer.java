package CodeWars;

import java.math.BigInteger;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.math.BigInteger.ONE;
import static java.util.regex.Pattern.compile;

public class StringIncrementer {

    //Examples:
    //foo -> foo1
    //foobar23 -> foobar24
    //foo0042 -> foo0043
    //foo9 -> foo10
    //foo099 -> foo100
    //foo000 -> foo001

    public static void main(String[] args) {
        System.out.println(incrementString("foobar23"));
        System.out.println(incrementString("foo0042"));
        System.out.println(incrementString("foo099"));
        System.out.println(incrementString("foo9"));
        System.out.println(incrementString("foo99"));
        System.out.println(incrementString("foo"));
        System.out.println(incrementString("foo000"));
        System.out.println(incrementString("1"));
//        System.out.println(incrementString("129500243489488343885220926304279"));
        System.out.println(incrementString("I?8mLfP:NkpT,5yd&L/Ow#/?6NA/+$k00001368037819893"));
        System.out.println(incrementString("kBp+QdWzz9Glr000009142189088"));
        System.out.println(incrementString("m+)|=YEqw,Ukfc12148712427937220466685404"));

    }

    public static String incrementStringBest1(String str) {
        String u = compile("(\\d+)$").matcher(str).replaceAll(x -> String.format("%0" + x.group().length() +"d", new BigInteger(x.group()).add(ONE)));
        return u.matches(".*(?<!\\d)")?u+1:u;
    }

    static String incrementStringBest2(String str) {
        return str.matches(".*(?<!\\d)") ? str + 1 : compile("\\d+$").matcher(str)
                .replaceAll(r -> String.format("%0" + r.group().length() + "d", new BigInteger(r.group()).add(ONE)));
    }

    public static String incrementStringGood2(String str) {

        List<String> check = Arrays.asList(new String[] {"0","1","2","3","4","5","6","7","8","9"});

        if(str.length()== 0|| !check.contains(str.substring(str.length()-1))){return str +"1";}


        return str.substring(str.length()-1).equals("9") ? incrementString(str.substring(0,str.length()-1)) +"0": str.substring(0,str.length()-1) + String.valueOf( Integer.parseInt( str.substring(str.length()-1) ) +1  );
    }

    public static String incrementStringGood3(String str) {
        System.out.println(str);
        Pattern pattern = compile("\\d{1,5}$");
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? str.replaceAll("\\d{1,5}$",
                String.format("%0" + matcher.group().length() + "d", Integer.parseInt(matcher.group()) + 1)) :
                str + 1;
    }

    public static String incrementStringGood4(String str) {
        StringBuilder arr = new StringBuilder(" " + str);
        for (int i = arr.length() - 1; i >= 0; i--) {
            char ch = arr.charAt(i);
            if (Character.isDigit(ch)) {
                ch = ch == '9' ? '0' : ++ch;
                arr.replace(i, i + 1, String.valueOf(ch));
                if (ch != '0') {
                    break;
                }
                continue;
            }
            arr.insert(i + 1, "1");
            break;
        }
        return arr.substring(1);
    }


    public static String incrementString(String str) {
        System.out.println("str : " + str);
        Pattern regex = compile("(\\d+)$");
//        Pattern regex = Pattern.compile("[^0-9]+([0-9]+)$");
        Matcher matcher = regex.matcher(str);

        String numGroup = null;
        while (matcher.find()) {
            numGroup = matcher.group(1);
        }

        if (numGroup != null) {

            String wordGroup = str.substring(0,str.length() - numGroup.length());
            System.out.println("word: " + wordGroup);

            StringBuilder numRev = new StringBuilder(numGroup);
            numRev.reverse();
            System.out.println("num: " + numRev);

            BigInteger bd = new BigInteger(numGroup);

            String num1 = bd.add(BigInteger.valueOf(1)).toString();
            StringBuilder num1Rev = new StringBuilder(num1);
            num1Rev.reverse();
            if (num1Rev.length() < numGroup.length()) {
                numRev.replace(0,num1Rev.length(),num1Rev.toString());
                return wordGroup + numRev.reverse();
            }
            return wordGroup + num1;

        } else {
            return str + "1";
        }

        // you code here
    }

    public static String incrementString1(String str) {

        if (str.length() < 1){
            return str + 1;
        }

        if (!Character.isDigit(str.charAt(str.length()-1))){
            return str + "1";
        }

        String num = "";
        int count = 0;

        for (int i = str.length()-1; i >= 0; i--){
            if (Character.isDigit(str.charAt(i))){
                num = str.charAt(i) + num;
                count++;
            } else {
                break;
            }
        }

        String substr = str.substring(0, str.length()-num.length());

        String numbs = new BigInteger(num).add(new BigInteger("1")).toString();

        if (numbs.length() != count){
            int n = count - numbs.length();
            for (int s = 0; s < n; s++){
                numbs = "0" + numbs;
            }
        }

        return substr + numbs;
    }
}
