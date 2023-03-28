package CodeWars;

import java.util.Arrays;

public class ArrayDiff {
    public static int[] arrayDiff(int[] a, int[] b) {
        for (int i = 0; i < b.length; i++) {
            int finalI = i;
            a = Arrays.stream(a).filter(num -> num != b[finalI]).toArray();
        }
        return a;
    }
}
