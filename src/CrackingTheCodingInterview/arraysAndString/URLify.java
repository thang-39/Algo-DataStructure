package CrackingTheCodingInterview.arraysAndString;

import java.util.Arrays;
import java.util.stream.Collectors;

public class URLify {
    //Write a method to replace all spaces in a string with '%20'
    public static void main(String[] args) {
        System.out.println(URLify("Mr 3ohn Smith"));
    }

    public static String URLify(String str) {
        return String.join("%20", str.split(" "));

    }
}
