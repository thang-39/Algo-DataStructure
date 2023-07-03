package hackerRank;

import java.util.Collections;
import java.util.List;

public class MinMaxSum {
    public static void main(String[] args) {

        miniMaxSum(List.of(1,3,5,7,9));
        miniMaxSum(List.of(396285104, 573261094, 759641832, 819230764, 364801279));

    }

    public static void miniMaxSum(List<Integer> arr) {


        long total0 = 0;
        long total1 = 0;
        long total2 = 0;
        long total3 = 0;
        long total4 = 0;

        for (int i = 0; i < arr.size(); i++) {
            if (i != 0) {
                total0 += arr.get(i);
            }
            if (i != 1) {
                total1 += arr.get(i);
            }
            if (i != 2) {
                total2 += arr.get(i);
            }
            if (i != 3) {
                total3 += arr.get(i);
            }
            if (i != 4) {
                total4 += arr.get(i);
            }
        }
        List<Long> list = List.of(total0,total1,total2,total3,total4);

        System.out.println(Collections.min(list)+ " " + Collections.max(list));

    }
}
