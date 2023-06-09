package CrackingTheCodingInterview.likedLists;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class RemoveDuplicates {

    public static void main(String[] args) {

        LinkedList<String> ll = new LinkedList<>();

        ll.add("Geeks");
        ll.add("Geeks");
        ll.add(1, "For");

        for (int i = 0; i < ll.size(); i++) {
            System.out.println(ll.get(i));
        }

        deleteDups(ll);
        System.out.println(ll);
    }

    public static void deleteDups(LinkedList<String> linkedList) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < linkedList.size(); i++) {
            if (!set.add(linkedList.get(i))) {
                linkedList.remove(i);
            }
        }


    }

}
