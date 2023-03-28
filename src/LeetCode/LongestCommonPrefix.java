package LeetCode;

import java.util.*;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {

        int smallestLen = strs[0].length();

        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < smallestLen) {
                smallestLen = strs[i].length();
            }
        }

        Map<Integer, Set<String>> strsMap = new HashMap<>();

        for (int i = 0; i < smallestLen; i++) {
            for (int j = 0; j < strs.length; j++) {
                Set<String> newSet = new HashSet<>();
                newSet.add(String.valueOf(strs[j].charAt(i)));
                if (!strsMap.containsKey(i)) {
                    strsMap.put(i, newSet);
                } else {
                    Set<String> old = strsMap.get(i);
                    old.add(String.valueOf(strs[j].charAt(i)));
                }
            }
        }

        String result = "";

        for (int i = 0; i < strsMap.size(); i++) {
            if (strsMap.get(i).size() == 1) {
                result += strsMap.get(i).iterator().next();
            } else {
                break;
            }
        }

        return result;
    }

    public static String longestCommonPrefixBest(String[] strs) {

        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length-1];
        int idx = 0;
        while(idx < s1.length() && idx < s2.length()){
            if(s1.charAt(idx) == s2.charAt(idx)){
                idx++;
            } else {
                break;
            }
        }
        return s1.substring(0, idx);
    }
}
