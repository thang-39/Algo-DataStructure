package takeuforward.recursion;

public class Lec02ProblemsOnRecursion {
    public static void main(String[] args) {
//        print1(5);
//        print2(1,5);
//        print3(5,5);
//        print4(5,5);
        print5(1,5);

    }

    // 1. Print name N time using recursion
    public static void print1(int n) {
        if (n == 0) return;
        System.out.println("Thang");
        print1(n-1);
    }

    public static void print2(int i, int n) {
        if (i > n) return;
        System.out.println(i);
        print2(i+1,n);
    }

    public static void print3(int i, int n) {
        if (i < 1) return;
        System.out.println(i);
        print3(i-1,n);
    }

    // backtracking with print 1-N (not allow i+1 - not use plus)

    public static void print4(int i, int n) {
        if (i < 1) return;
        print4(i-1,n);
        System.out.println(i);
    }

    public static void print5(int i, int n) {
        if (i > n) return;
        print5(i+1, n);
        System.out.println(i);
    }
}
