package CodeWars;

import java.util.Arrays;

public class AreTheyTheSame {

    public static boolean comp(int[] a, int[] b) {

        if (a == null || b == null) {
            return false;
        }

        if (a.length == 0 && b.length == 0) {
            return true;
        }

        if (a.length != b.length) {
            return false;
        }

        a = Arrays.stream(a).map(num -> num*num).toArray();

        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }

        }
        return true;


    }
}
