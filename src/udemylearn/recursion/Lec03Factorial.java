package udemylearn.recursion;

public class Lec03Factorial {

    public static void main(String[] args) {
        System.out.println(head(5));
        System.out.println(tail(5,1));
    }

    public static int head(int n) {
        if (n == 1) return 1;

        int res1 = head(n-1);
        int result = n*res1;

        return result;
    }

    public static int tail(int n, int accumulator) {
        if (n == 1) return accumulator;
        return tail(n-1, n*accumulator);
    }
}
