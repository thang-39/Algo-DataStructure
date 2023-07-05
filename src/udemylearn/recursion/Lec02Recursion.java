package udemylearn.recursion;

public class Lec02Recursion {
    public static void main(String[] args) {
//        head(5);
        tail(5);
    }
    public static void head(int n) {

        System.out.println("call the function with value n= " + n);

        if (n==0) return;

        head(n-1);

        System.out.println("the value n= " + n);
    }

    public static void tail(int n) {

        System.out.println("call the function with value n= " + n);

        if (n == 0) return;

        System.out.println("the value n= " + n);

        tail(n-1);
    }
}
