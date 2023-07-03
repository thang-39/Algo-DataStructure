package hackerRank;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LonelyInteger {
    public static int lonelyInteger(List<Integer> a) {
        // Write your code here

        return a.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .toList().get(0);


    }
}
