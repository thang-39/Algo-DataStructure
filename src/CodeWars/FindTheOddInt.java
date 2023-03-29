package CodeWars;

public class FindTheOddInt {
    public static void main(String[] args) {
        findIt(new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5});

    }

    //use map



    //brute force
    public static int findIt(int[] a) {
        int temp = 0;
        int count = 0;
        for (int j = 0; j < a.length; j++) {
            for (int i = 0; i < a.length; i++) {
                temp = a[j];
                if (temp == a[i]) {
                    count +=1;
                }
            }
            if (count % 2 != 0) {
                break;
            }
        }
        System.out.println(temp);
        return temp;
    }
}
