package CodeWars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SimplePigLatin {

    /* Move the first letter of each word to the end of it,
    then add "ay" to the end of the word.
    Leave punctuation marks untouched.

    Example:
    pigIt('Pig latin is cool'); // igPay atinlay siay oolcay
    pigIt('Hello world !');     // elloHay orldway !
     */
    public static void main(String[] args) {
        pigIt("Pig latin is cool");
        pigIt("Hello world !");
    }

    public static String pigItBest(String str) {
        return str.replaceAll("(\\w)(\\w*)", "$2$1ay");
    }

    public static String pigItStream(String str) {
        return Arrays.stream(str.trim().split(" "))
                .map(v -> v.matches("[a-zA-Z]+") ? v.substring(1).concat(v.substring(0, 1)).concat("ay") : v)
                .collect(Collectors.joining(" "));
    }
    public static String pigIt(String str) {
        String[] wList = str.split(" ");
        System.out.println(Arrays.toString(wList));

        List<String> result = new ArrayList<>();
        for (String w : wList) {
            if (!Pattern.matches("\\p{Punct}", w)) {
                StringBuilder sb = new StringBuilder(w);
                sb.append(sb.charAt(0)).append("ay").delete(0,1);
                result.add(sb.toString());
            } else {
                result.add(w);
            }

        }
        System.out.println(String.join(" ",result));
        return String.join(" ",result);
    }

    //explain for best way
    private static final Pattern regex = Pattern.compile("(\\w)(\\w*)");

    public static String pigItBestExplain(String str) {
        return regex.matcher(str).replaceAll("$2$1ay");
    }
}
