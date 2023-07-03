package hackerRank;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.stream;

public class PrintDecimalNegativePositiveZero {
    public static void main(String[] args) {
        plusMinus(List.of(-4, 3, -9, 0, 4, 1));
    }
    public static void plusMinus(List<Integer> arr) {

        // Write your code here
        int total = arr.size();
        System.out.println( Math.round( (double) arr.stream().filter(n -> n > 0).count() / total * 1000000d) / 1000000d ) ;
        System.out.println( Math.round( (double) arr.stream().filter(n -> n < 0).count() / total * 1000000d) / 1000000d ) ;
        System.out.println( Math.round( (double) arr.stream().filter(n -> n == 0).count() / total * 1000000d) / 1000000d ) ;


    }
}
