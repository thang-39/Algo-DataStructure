package takeuforward.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lec06Subsequences {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        printSubsequences(0, new ArrayList<>(), arr);

    }

    public static void printSubsequences(int index, List<Integer> subsequence, int[] arr)  {
        if (index >= arr.length) {
            System.out.println(subsequence);
            return;
        }

        subsequence.add(arr[index]);
        printSubsequences(index + 1, subsequence, arr); // take
        subsequence.remove(subsequence.size()-1);
        printSubsequences(index + 1, subsequence, arr); // not take

    }
}
