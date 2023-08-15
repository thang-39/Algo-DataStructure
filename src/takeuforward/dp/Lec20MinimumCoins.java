package takeuforward.dp;
// https://www.codingninjas.com/studio/problems/minimum-coins_982764
public class Lec20MinimumCoins {

    public static void main(String[] args) {
        System.out.println(minimumCoins(3));
        System.out.println(minimumCoins(60));
        System.out.println(minimumCoins(10));
        System.out.println(minimumCoins(24));
    }

    public static int minimumCoins(int p){
        int[] arr = {1,2,5,10,20,50,100,500,1000};
        int n = arr.length;
        return recursion(n-1, p, arr);
    }

    private static int recursion(int index, int target, int[] arr) {
        if (index == 0) {
            if (target % arr[index] == 0) return target/arr[index];
            return (int) 1e9;
        }

        int notTake = recursion(index-1, target, arr);

        int take = (int) 1e9;
        if (arr[index] <= target) {
            take = 1 + recursion(index,target-arr[index],arr);
        }
        return Math.min(notTake, take);
    }
}
