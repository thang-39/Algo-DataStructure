package CodeWars;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class DuplicateEncoder {
    static String encode(String word){
        char[] charArray = word.toLowerCase().toCharArray();

        List<String> charList = new ArrayList<>();

        for (char c : charArray) {
            charList.add(String.valueOf(c));
        }


        Map<String,Long> charMap = charList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (int i = 0; i < charList.size(); i++) {
            if (charMap.get(charList.get(i)) > 1) {
                charList.set(i,")");
            } else charList.set(i,"(");
        }

        StringBuffer sb = new StringBuffer();
        for (String s : charList) {
            sb.append(s);
        }

        return sb.toString();
    }
}
