package CodeWars;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindTheOddInt {
    public static void main(String[] args) {
       // findItMap(new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5});
        System.out.println(findItBest(new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5}));
        System.out.println(findItBest(new int[]{1,1,1,1,1,1,10,1,1,1,1}));


    }


    // 1 line
    public static int findItBest(int[] a) {
        int odd=0;
        for (int item: a)
        {
            odd = odd ^ item;// XOR will cancel out everytime you XOR with the same number so 1^1=0 but 1^1^1=1 so every pair should cancel out leaving the odd number out
        }
        return odd;
    }

    //use map
    public static int findItMap(int[] a) {
        int value;
        Map<Integer,Integer> map = new HashMap<>();

                for (int i = 0; i < a.length; i++) {
            if (map.containsKey(a[i])) {
                value = map.get(a[i]);
                map.remove(a[i]);
                map.put(a[i], ++value);

            } else {
                map.put(a[i],1);
            }
        }
        System.out.println(map);

        int result = 0;
        for (int i : map.keySet()) {
            if (map.get(i) % 2 !=0) {
                result = i;
                break;
            }

        }
        System.out.println(result);
        return result;

    }

    private static Map<Integer, Integer> newMap(int [] a){
        Map<Integer,Integer> map = new HashMap<>();
        int value;
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(a[i])) {
                value = map.get(a[i]);
                map.remove(a[i]);
                map.put(a[i], ++value);

            } else {
                map.put(a[i],1);
            }
        }
        return map;
    }

    //brute force - with save already iterated num to ignore next time
    public static int findIt(int[] a) {
        int temp = 0;
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int j = 0; j < a.length; j++) {
            if (set.contains(a[j])) continue;
            for (int i = 0; i < a.length; i++) {
                temp = a[j];
                if (temp == a[i]) {
                    count +=1;
                }
            }
            if (count % 2 != 0) {
                break;
            } else {
                set.add(temp);
            }
        }
        System.out.println(temp);
        return temp;
    }
}
