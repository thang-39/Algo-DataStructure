package udemylearn.search;

public class Lec01LinearSearch {
    public static void main(String[] args) {
        System.out.println(recursiveFind(new int[] {1, 5, -3, 10, 55, 100},10,0));
    }

    public static int recursiveFind(int[] container, int item, int index) {
        if (index == container.length) return -1;
        if (container[index] == item) return index;
        return recursiveFind(container,item, index + 1);
    }
}
