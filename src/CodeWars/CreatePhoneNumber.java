package CodeWars;

import java.util.Arrays;

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
}
