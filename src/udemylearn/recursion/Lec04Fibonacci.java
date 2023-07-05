package udemylearn.recursion;

public class Lec04Fibonacci {
    public static void main(String[] args) {
        System.out.println(head(5));
        System.out.println(tailThang(5,0,0));
        System.out.println(tail(5,0,1));
    }

    public static int head(int n) {
        if(n==0) return 0;
        if(n==1) return 1;

        int fib1 = head(n-1);
        int fib2 = head(n-2);

        int result = fib1 + fib2;

        return result;
    }

    public static int tailThang(int n, int acc1, int acc2) {
        if(n==0) return acc1;
        if(n==1) return 1 + acc2;

        return tail(n-2,acc1,acc2) + tail(n-1,acc1, acc2);
    }

    public static int tail(int n, int a, int b) {
        if(n==0) return a;
        if(n==1) return b;

        return tail(n-1,b,a+b);
    }
}
