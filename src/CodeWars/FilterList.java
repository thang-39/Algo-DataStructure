package CodeWars;

import java.util.List;
import java.util.stream.Collectors;

public class FilterList {
    public static List<Object> filterList(final List<Object> list) {
        return list.stream().filter(e -> e instanceof Integer).collect(Collectors.toList());
    }
}
