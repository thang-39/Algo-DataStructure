package LeetCode;

import java.util.*;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
        System.out.println();
        System.out.println(isValid("{}"));
        System.out.println();
        System.out.println(isValid("[]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("(])"));
    }

    public static boolean isValid(String s) {
        char[] strArr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        map.put('{','}');
        map.put('(',')');
        map.put('[',']');

        for (char c : strArr) {
            if (map.containsKey(c)) {
                stack.add(map.get(c));
            } else if (!stack.empty() && stack.peek() == c) {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.empty();
    }
    public static boolean isValidWrong(String s) {

        // fail this case "([)]"

        int apostrophe = 39;
        int openParentheses = 40;
        int closeParentheses = 41;
        int openSquareBracket = 91;
        int closeSquareBracket = 93;
        int openCurlyBracket = 123;
        int closeCurlyBracket = 125;

        char[] split = s.toCharArray();
        System.out.println(Arrays.toString(split));
        Map<Integer,Integer> map = new HashMap<>();
        map.put((int) split[0], 1);

        for (int i = 1; i < split.length; i++) {
            if ((int) split[i] == apostrophe) {
                if (map.containsKey(apostrophe)) {
                    map.put(apostrophe, map.get(apostrophe) - 1);
                } else {
                    map.put(apostrophe,1);
                }
            }

            if ((int) split[i] == openParentheses) {
                if (map.containsKey(openParentheses)) {
                    map.put(openParentheses, map.get(openParentheses) + 1);
                } else map.put(openParentheses, 1);
            }

            if ((int) split[i] == closeParentheses) {
                if (map.containsKey(openParentheses)) {
                    map.put(openParentheses, map.get(openParentheses) - 1);
                } else return false;
            }

            if ((int) split[i] == openSquareBracket) {
                if (map.containsKey(openSquareBracket)) {
                    map.put(openSquareBracket, map.get(openSquareBracket) + 1);
                } else map.put(openSquareBracket, 1);
            }

            if ((int) split[i] == closeSquareBracket) {
                if (map.containsKey(openSquareBracket)) {
                    map.put(openSquareBracket, map.get(openSquareBracket) - 1);
                } else return false;
            }

            if ((int) split[i] == openCurlyBracket) {
                if (map.containsKey(openCurlyBracket)) {
                    map.put(openCurlyBracket, map.get(openCurlyBracket) + 1);
                } else map.put(openCurlyBracket, 1);
            }

            if ((int) split[i] == closeCurlyBracket) {
                if (map.containsKey(openCurlyBracket)) {
                    map.put(openCurlyBracket, map.get(openCurlyBracket) - 1);
                } else return false;
            }


        }
        System.out.println(map);
        List<Integer> values = new ArrayList<>(map.values());

        for (Integer value : values) {
            if (value != 0) {
                return false;
            }
        }

        return true;


    }
}
