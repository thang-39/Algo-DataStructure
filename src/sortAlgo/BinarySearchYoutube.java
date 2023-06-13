package sortAlgo;

public class BinarySearchYoutube {
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1, 2, 4, 5, 6, 9, 10},10));
    }

    private static int binarySearch(int[] numbers, int numberToFind) {
        int low = 0;
        int high = numbers.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (numbers[mid] == numberToFind) {
                return mid;
            } else if (numbers[mid] < numberToFind) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
