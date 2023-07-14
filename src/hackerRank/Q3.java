package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q3 {
    public static void main(String[] args) {
        System.out.println(gainMaxValue(List.of(2,-3,4,6,1),2));
        System.out.println(gainMaxValueThang(List.of(2,-3,4,6,1),2));
    }

    public static int gainMaxValueThang(List<Integer> security, int k) {
        int sum = 0;

        List<Integer> sumList = new ArrayList<>();

//        recursionJump(0, security, k, sum, sumList);
        System.out.println(sumList);

        return Collections.max(sumList);
    }

    public static int recursionJump(int index, List<Integer> arr) {
        if (index == 0)




    }

    public static int gainMaxValue(List<Integer> security, int k) {
//        System.out.println(security);
//        System.out.println(k);

        if(security.size() == 1) {
            return security.get(0);
        }

        int start = 0;

        List<Integer> gain = new ArrayList<>();
        recursion(security, gain, k, start);

        return Collections.max(gain);
    }
    private static void recursion(List<Integer> security, List<Integer> gain, int k, int start) {
        int tong = 0;

        if(start >= security.size()) {
            return;
        }
        for(int i = start ;  i <= security.size()-1 ; i=i+k) {

            tong = tong + security.get(i);
        }

        gain.add(tong);
        recursion(security,gain, k, ++start);
    }
}
