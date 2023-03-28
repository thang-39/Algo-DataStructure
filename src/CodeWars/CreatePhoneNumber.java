package CodeWars;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CreatePhoneNumber {
    public static void main(String[] args) {
        createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
    }
    public static String createPhoneNumber(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (int i = 0; i<3; i++) {
            sb.append(numbers[i]);
        }
        sb.append(") ");

        for (int i = 3; i < 6; i++) {
            sb.append(numbers[i]);
        }
        sb.append("-");

        for (int i = 6; i < numbers.length; i++) {
            sb.append(numbers[i]);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static String createPhoneNumberBest1(int[] numbers) {
        return String.format("(%d%d%d) %d%d%d-%d%d%d%d", IntStream.of(numbers).boxed().toArray());
    }

    private static String PHONE_FORMAT = "(%d%d%d) %d%d%d-%d%d%d%d";

    public static String createPhoneNumberBest2(int[] numbers) {
        Integer[] numbersInt = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
        return String.format(PHONE_FORMAT, numbersInt);
    }
}
