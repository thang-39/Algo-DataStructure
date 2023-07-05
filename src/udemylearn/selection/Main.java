package udemylearn.selection;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,-5,10,55,2,3,-7,7,11,100};
        QuickSelect qS = new QuickSelect(nums);

        System.out.println(qS.select(5));

    }
}
