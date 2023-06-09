package CrackingTheCodingInterview.arraysAndString;

import java.util.Arrays;

public class CheckPermutation {

    // Check Permutation (hoán vị) : Given two strings,
    // write a method to decide if one is a permutation of the other.
    // example: "god" and "dog" return true
    // "dog  " and "god" return false

    //easy way
    public static void main(String[] args) {
        System.out.println(isPermutation("dog", "god"));
        System.out.println(isPermutation("dog  ", "god"));
    }

    public static boolean isPermutation(String a , String b) {
        if (a.length() != b.length()) return false;

        int[] char_set = new int[128];

        for (char c: a.toCharArray()) {
            char_set[c]++;
        }

        for (int i = 0; i < b.length(); i++) {
            int val = b.charAt(i);
            char_set[val]--;
            if (char_set[val] < 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPermutation1(String a, String b) {
        if (a.length() != b.length()) return false;

        char[] a_array = a.toCharArray();
        Arrays.sort(a_array);

        char[] b_array = b.toCharArray();
        Arrays.sort(b_array);

        for (int i = 0; i < a_array.length; i++) {
            if (a_array[i] != b_array[i]) {
                return false;
            }
        }
        return true;
    }
}
