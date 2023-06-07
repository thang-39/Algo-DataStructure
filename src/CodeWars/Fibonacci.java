package CodeWars;

public class Fibonacci {

    public static long[] fibonacciCache;

    public static void main(String[] args) {

        int n = 88;

        fibonacciCache = new long[n+1];

        System.out.println(fibonacci(n));
    }
    public static long fibonacci(int n) {
        if ( n <= 1) {
            return n;
        }

        if (fibonacciCache[n] != 0) {
            return fibonacciCache[n];
        }

        long nthFibonacciNum = fibonacci(n-2) + fibonacci(n-1);
        fibonacciCache[n] = nthFibonacciNum;
        return nthFibonacciNum;
    }
}
