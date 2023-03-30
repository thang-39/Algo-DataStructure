package CodeWars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WriteNumberInExpandedForm {
    public static void main(String[] args) {
        expandedForm(10);
        expandedForm(12);
        expandedForm(40304);
    }
    public static String expandedForm(int num) {
        List<Integer> digitList = new ArrayList<>();

        while (num > 0) {
            digitList.add(num % 10);
            num = num / 10;
        }

        Collections.reverse(digitList);
        System.out.println(digitList);

        StringBuffer sb = new StringBuffer();

        int len = digitList.size();
        int index = 0;

        while (len > 0) {
            if (digitList.get(index) != 0) {
                sb.append(digitList.get(index) * (int) Math.pow(10,--len));
                sb.append(" + ");
            } else {
                len--;
            }
            index++;
        }

        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);

        System.out.println(sb.toString());

        return sb.toString();
    }
}
