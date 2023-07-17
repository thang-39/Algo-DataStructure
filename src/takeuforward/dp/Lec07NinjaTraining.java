package takeuforward.dp;

import java.util.Arrays;

// https://www.codingninjas.com/studio/problems/ninja-s-training_3621003
public class Lec07NinjaTraining {
    public static void main(String[] args) {
        int[][] points1 = {{1,2,5},{3,1,1},{3,3,3}};
        int[][] points2 = {{18, 11, 19},{4, 13, 7},{1, 8, 13}};
        int[][] points3 = {{10, 50, 1}, {5, 100, 11}};

        System.out.println(ninjaTraining(3,points1));
        System.out.println(ninjaTraining(3,points2));
        System.out.println(ninjaTraining(2,points3));

        System.out.println(ninjaTrainingMemorization(3,points1));
        System.out.println(ninjaTrainingMemorization(3,points2));
        System.out.println(ninjaTrainingMemorization(2,points3));


    }

    public static int ninjaTraining(int n, int points[][]) {
        int lastTask = 0;
        int day = n-1;
        return recursion(day, lastTask, points);
    }

    private static int recursion(int day, int lastTask, int[][] points) {
        int maxi = 0;
        if (day == 0) {
            for (int i = 0; i <= 2; i++) {
                if (i != lastTask)
                    maxi = Math.max(points[day][i], maxi);
            }
            return maxi;
        }

        for (int task = 0; task <= 2 ; task++) {
            if (task != lastTask) {
                int point = points[day][task] + recursion(day-1,task,points);
                maxi = Math.max(maxi,point);
            }
        }
        return maxi;
    }

    public static int ninjaTrainingMemorization(int n, int points[][]) {
        int lastTask = 0;
        int day = n-1;
        int[][] dp= new int[n][4];
        return recursionMemorization(day, lastTask, points, dp);
    }

    private static int recursionMemorization(int day, int lastTask, int[][] points,
                                             int[][] dp) {
        if (dp[day][lastTask] != 0) return dp[day][lastTask];
        int maxi = 0;
        if (day == 0) {
            for (int i = 0; i <= 2; i++) {
                if (i != lastTask)
                    maxi = Math.max(points[day][i], maxi);
            }
            return maxi;
        }

        for (int task = 0; task <= 2 ; task++) {
            if (task != lastTask) {
                int point = points[day][task] + recursionMemorization(day-1,task,points,dp);
                maxi = Math.max(maxi,point);
            }
        }
        return dp[day][lastTask] = maxi;
    }
}
