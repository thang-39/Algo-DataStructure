package takeuforward.dp;

public class Lec02ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbingStairs(3));
    }

    public static int climbingStairs(long n) {
        if (n <= 2) return (int) n;
        return climbingStairs(n-1) + climbingStairs(n-2);
    }
}
