package LeetCode;

public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
    public static int climbStairs(int n) {
        if (n == 0) return 1;

        if (n == 1) return 1;

        return climbStairs(n-1) + climbStairs(n-2);
    }



}
