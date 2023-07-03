package hackerRank;

import java.util.List;

public class JumpCloud {

    public static void main(String[] args) {
        List<Integer> c1 = List.of(0,0, 1, 0, 0, 1, 0);
        List<Integer> c = List.of(0, 0, 0, 1, 0, 0);
        System.out.println(jumpingOnClouds(c1));
    }

    public static int jumpingOnClouds(List<Integer> c) {
        int index = 0;
        int count = 0;

        while (index < c.size()-1) {
            if ( index + 2 < c.size() && c.get(index + 2) == 0) {
                index += 2;
            } else {
                index++;
            }
            count++;
        }
        return count;
    }
}
