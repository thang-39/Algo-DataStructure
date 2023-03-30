package CodeWars;

import java.util.*;
import java.util.stream.Collectors;

public class GreedIsGood {

    /*  Three 1's => 1000 points
        Three 6's =>  600 points
        Three 5's =>  500 points
        Three 4's =>  400 points
        Three 3's =>  300 points
        Three 2's =>  200 points
        One   1   =>  100 points
        One   5   =>   50 point
    */
    public static void main(String[] args) {
//        greedy(new int[]{5,1,3,4,1});
//        greedy(new int[]{1,1,1,3,1});
//        greedy(new int[]{2,4,4,5,4});
//        greedy(new int[]{2,5,5,5,4});
        greedy(new int[]{1,6,6,6,6});
//        System.out.println((new int[7]).length);


    }



    public static int greedy(int[] dice){
        int[] n = new int[7];
        for (int d : dice) n[d]++;
        return n[1]/3*1000 + n[1]%3*100 + n[2]/3*200 + n[3]/3*300 + n[4]/3*400 + n[5]/3*500 + n[5]%3*50 + n[6]/3*600;
    }

    public static int greedy1(int[] dice){

        int score = 0;

        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < dice.length; i++) {
            if (!map.containsKey(dice[i])) {
                map.put(dice[i],1);
            } else {
                map.put(dice[i],map.get(dice[i]) + 1);
            }
        }
        System.out.println(map);

        if (map.containsKey(1)) {
            if (map.get(1) <= 2) {
                score += 100 * map.get(1);
            } else {
                score += 1000 + 100 * (map.get(1)%3);
            }
        }

        if (map.containsKey(5)) {
            if (map.get(5) <= 2) {
                score += 50 * map.get(5);
            } else {
                score += 500 + 50 * (map.get(5)%3);
            }
        }

        int[] array_2_3_4_6 = new int[]{2,3,4,6};

        for (int i : array_2_3_4_6) {
            if (map.containsKey(i)) {
                if (map.get(i) >= 3) {
                    score += i*100;
                }
            }
        }

        System.out.println(score);
        return score;
    }
}
