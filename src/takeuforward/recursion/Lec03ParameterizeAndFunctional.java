package takeuforward.recursion;

public class Lec03ParameterizeAndFunctional {
    public static void main(String[] args) {
        sum(3,0);
        System.out.println(sum(3));
    }

    // parameterize way
    public static void sum(int i, int sum) {
        if (i < 1) {
            System.out.println(sum);
            return;
        }
        sum(i-1, sum + i);
    }

    // functional
    public static int sum(int i) {
        if (i == 1) return 1;
        return i + sum(i-1);
    }
}
