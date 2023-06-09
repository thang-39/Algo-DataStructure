package CrackingTheCodingInterview.arraysAndString;

import java.util.Arrays;

public class IsUnique {
    public static void main(String[] args) {
        System.out.println(isUniqueChars("abadc"));

//        String a = "abcd";
//        int val = a.charAt(0);
//        System.out.println(val);


//        boolean[] char_set1 = new boolean[1];
//        char_set1[]
    }

    public static boolean isUniqueChars(String str) {
        if (str.length() > 128) return false;

        boolean[] char_set = new boolean[128];
        System.out.println(Arrays.toString(char_set));
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }
}
