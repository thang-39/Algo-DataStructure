package CodeWars;

import java.util.*;
//https://www.codewars.com/kata/578aa45ee9fd15ff4600090d/train/java
public class SortTheOdd {
    public static void main(String[] args) {
        sortArray(new int[]{ 5, 3, 2, 8, 1, 4 });
    }
    public static int[] sortArray(int[] array) {
        Map<String, List<Integer>> positionMap = new HashMap<>();
        positionMap.put("even",new ArrayList<>());
        positionMap.put("odd",new ArrayList<>());

        Map<String, List<Integer>> oddOrEvenMap = new HashMap<>();
        oddOrEvenMap.put("even",new ArrayList<>());
        oddOrEvenMap.put("odd",new ArrayList<>());

        for (int i = 0; i < array.length; i++) {

            if (array[i] % 2 != 0) {
                positionMap.get("odd").add(i);
                oddOrEvenMap.get("odd").add(array[i]);
            } else {
                positionMap.get("even").add(i);
                oddOrEvenMap.get("even").add(array[i]);
            }

        }
        oddOrEvenMap.get("odd").sort(Comparator.naturalOrder());
        System.out.println(positionMap);
        System.out.println(oddOrEvenMap);

        int index = 0;
        for (int i : positionMap.get("odd")) {
            array[i] = oddOrEvenMap.get("odd").get(index);
            index += 1;
        }
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + ", " );
//        }
        return array;




    }
}
