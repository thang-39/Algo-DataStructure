package LeetCode;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PlusOne {
    public static void main(String[] args) {
        plusOne(new int[]{1,2,3});
        plusOne(new int[]{9,8,7,6,5,4,3,2,1,0});
    }
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
    public static int[] plusOneGa(int[] digits) {

        String numStr = Arrays.stream(digits).mapToObj(Long::toString).collect(Collectors.joining(""));

        BigInteger numBig = new BigInteger(numStr);

        BigInteger numPlusOne = numBig.add(BigInteger.valueOf(1));

        char[] numChar = numPlusOne.toString().toCharArray();

        int[] result = new int[numChar.length];

        for (int i = 0; i < numChar.length; i++) {
            result[i] = Character.getNumericValue(numChar[i]);
        }

        return result ;
    }
}
