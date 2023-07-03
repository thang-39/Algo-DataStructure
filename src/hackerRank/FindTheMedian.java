package hackerRank;

import java.util.Comparator;
import java.util.List;

public class FindTheMedian {
    public static void main(String[] args) {

    }

    public static int findMedian(List<Integer> arr) {
        arr.sort(Comparator.naturalOrder());
        return arr.get(arr.size()/2);

    }


}
