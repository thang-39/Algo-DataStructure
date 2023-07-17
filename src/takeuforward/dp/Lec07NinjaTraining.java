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

        System.out.println(ninjaTrainingTabulation(3,points1));
        System.out.println(ninjaTrainingTabulation(3,points2));
        System.out.println(ninjaTrainingTabulation(2,points3));

        System.out.println(ninjaTrainingTabulationSpaceOptimize(3,points1));
        System.out.println(ninjaTrainingTabulationSpaceOptimize(3,points2));
        System.out.println(ninjaTrainingTabulationSpaceOptimize(2,points3));
    }

    public static int ninjaTraining(int n, int points[][]) {
        int lastTask = 3; //  initialize with index out of 3 tasks
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
        int lastTask = 3;
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

    private static int ninjaTrainingTabulation(int n, int[][] points) {

        int[][] dp = new int[n][4];

        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                for (int task = 0; task <= 2 ; task++) {
                    if (task != last) {
                        int point = points[day][task] + dp[day-1][task];
                        dp[day][last] = Math.max(dp[day][last],point);
                    }
                }
            }
        }
        return dp[n-1][3];
    }

    private static int ninjaTrainingTabulationSpaceOptimize(int n, int[][] points) {

        int[] prev = new int[4];

        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            int[] temp = new int[4];
            for (int last = 0; last < 4; last++) {
                for (int task = 0; task <= 2 ; task++) {
                    if (task != last) {
                        temp[last] = Math.max(temp[last],points[day][task] + prev[task]);
                    }
                }
            }
            prev = temp;
        }
        return prev[3];
    }
}
