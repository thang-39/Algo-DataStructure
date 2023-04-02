package CodeWars;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

public class HumanReadableDurationFormat {
    // https://www.codewars.com/kata/52742f58faf5485cae000b9a/train/java
    // combination of years, days, hours, minutes and seconds.

    // Example:

    // For seconds = 62, your function should return
    //    "1 minute and 2 seconds"

    // For seconds = 3662, your function should return
    //    "1 hour, 1 minute and 2 seconds"

    public static void main(String[] args) {
//        System.out.println(formatDuration(3662));
//        System.out.println(formatDuration(1));
        System.out.println(formatDuration(5898954));
    }
    public static String formatDuration(int seconds) {
        if (seconds == 0) return "now";

        int[] timeMap = new int[5];

        int time = seconds;



            timeMap[0] = time % 60; // sec
            time = time / 60; // min

            timeMap[1] = time % 60; // min
            time = time / 60; // hour

            timeMap[2] = time % 24; // hour
            time = time / 24; // day

            timeMap[3] = time % 365; // day

            timeMap[4] = time / 365; // year


        System.out.println(Arrays.toString(timeMap));
        StringBuilder sb = new StringBuilder();

        List<String> timeList = new ArrayList<>();

        for (int i = 4; i >=0; i--) {
            switch (i) {
                case 0 -> {
                    if (timeMap[i] == 0) break;
                    if (timeMap[i] > 1) {
                        timeList.add(timeMap[i] + " seconds");
                    } else {
                        timeList.add(timeMap[i] + " second");
                    }
                }
                case 1 -> {
                    if (timeMap[i] == 0) break;
                    if (timeMap[i] > 1) {
                        timeList.add(timeMap[i] + " minutes");
                    } else {
                        timeList.add(timeMap[i] + " minute");
                    }
                }
                case 2 -> {
                    if (timeMap[i] == 0) break;
                    if (timeMap[i] > 1) {
                        timeList.add(timeMap[i] + " hours");
                    } else {
                        timeList.add(timeMap[i] + " hour");
                    }
                }
                case 3 -> {
                    if (timeMap[i] == 0) break;
                    if (timeMap[i] > 1) {
                        timeList.add(timeMap[i] + " days");
                    } else {
                        timeList.add(timeMap[i] + " day");
                    }
                }
                case 4 -> {
                    if (timeMap[i] == 0) break;
                    if (timeMap[i] > 1) {
                        timeList.add(timeMap[i] + " years");
                    } else {
                        timeList.add(timeMap[i] + " year");
                    }
                }
            }
        }

        System.out.println(Arrays.toString(timeMap));
        System.out.println(timeList);
        System.out.println(String.join(", ",timeList));

        if (timeList.size() > 1) {
            String last = timeList.get(timeList.size() - 1);
            timeList.remove(timeList.size() - 1);
            return String.join(", ",timeList) + " and " + last;
        } else {
            return timeList.get(0);
        }


    }
}
