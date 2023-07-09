package takeuforward.recursion;

public class Lec05MultipleRecursionCall {
    public static void main(String[] args) {
        System.out.println(fibonacci(0));
        System.out.println(fibonacci(1));
        System.out.println(fibonacci(2));
        System.out.println(fibonacci(3));
        System.out.println(fibonacci(5));
    }

    public static int fibonacci(int n) {
        if (n <= 1) return n;
        int last =  fibonacci(n-1);
        int secondLast = fibonacci(n-2);
        return last + secondLast;
    }
}
