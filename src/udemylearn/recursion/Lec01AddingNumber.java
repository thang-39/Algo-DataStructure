package udemylearn.recursion;

public class Lec01AddingNumber {
    public static void main(String[] args) {
        System.out.println(iteration(5000));
        System.out.println(recursion(5000));
    }

    public static int iteration(int n) {
        int result = 0;

        for (int i = 1; i <= n; i++) {
            result += i;
        }

        return result;
    }

    public static int recursion(int n) {
        if (n == 1) return 1;
        return n + recursion(n-1);
    }
}
