package CodeWars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PersistentBugger {
    public static void main(String[] args) {
        System.out.println(persistence2(39));
        System.out.println(persistence2(999));
        System.out.println(persistence2(4));
//        persistence2(999);
//        persistence2(4);


    }

    public static int otherPersistence(long n) {
        long m = 1, r = n;

        if (r / 10 == 0)
            return 0;

        for (r = n; r != 0; r /= 10)
            m *= r % 10;

        return persistence(m) + 1;
    }

    public static int persistence2(long n) {

        if (n / 10 == 0) {
            return 0;
        }

        long multi = 1;

        for (char i : Long.toString(n).toCharArray()) {
            multi *= Long.parseLong(String.valueOf(i));
        }

        return persistence2(multi) + 1;
    }


    public static int persistence1(long n) {
        int time = 0;

        while (n > 9) {
            int multi = 1;
            for (int i = 0; i < Long.toString(n).toCharArray().length; i++) {
                multi *= Long.parseLong(String.valueOf(Long.toString(n).toCharArray()[i]));
            }
            n = multi;
            time++;
        }
        System.out.println(time);

        return time;
    }
    public static int persistence(long n) {
        int time = 0;


        while(n > 9){

            long mutil = 1;
            for(char x : String.valueOf(n).toCharArray()) {

                mutil *= Long.parseLong(String.valueOf(x));
            }
            n = mutil;
            time ++;

        }
        System.out.println(time);
        return time;
    }
}
