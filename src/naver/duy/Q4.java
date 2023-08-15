package naver.duy;

import java.util.Comparator;
import java.util.List;

public class Q4 {
    public static void main(String[] args) {
        System.out.println(minStart(List.of(3,-6,5,-2,1)));
        System.out.println(minStart(List.of(-4,3,2,1)));
    }

    public static long minStart(List<Integer> arr) {
        int min = arr.stream().min(Comparator.naturalOrder()).get();

        if (min >= 0) return 1;

        for (int i = 1; i <= min*-1 + 1; i++) {
            if (sumTo1(arr,i))
                return i;
        }

        return 1;
    }

    private static boolean sumTo1(List<Integer> arr, int x) {
        int result = x;
        for (Integer integer : arr) {
            result += integer;
            if (result <= 0) return false;
        }
        return true;
    }




}
