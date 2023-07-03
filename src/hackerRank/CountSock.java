package hackerRank;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountSock {
    public static void main(String[] args) {

        List<Integer> ar = List.of(1,2,1,2,1,3,2);
        System.out.println(sockMerchant(7,ar));

    }

    public static int sockMerchant(int n, List<Integer> ar) {
        return ar.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values().stream().map(l -> l / 2).reduce(0L, Long::sum).intValue();
    }
}
