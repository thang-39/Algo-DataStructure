package hackerRank;

public class PowerSum {
    public static void main(String[] args) {

        System.out.println(powerSum(100, 2));
//        int maxIndex = (int) Math.pow(123, (double) 1 /4);
//        System.out.println(maxIndex);
    }

    public static int powerSum(int x, int n) {
        return recursion(x, n, 1);
    }

    private static int recursion(int target, int power, int num) {
        int remain = target - (int) Math.pow(num, power);
        if (remain == 0)
            return 1;
        else if (remain < 0)
            return 0;
        else
            return recursion(target,power,num+1) + recursion(remain,power,num+1);
    }


}
