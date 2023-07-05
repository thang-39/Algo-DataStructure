package udemylearn.recursion;

public class Lec05TowersOfHanoi {
    public static void main(String[] args) {
        solve(64, 'a','b','c');
    }

    public static void solve(int disk, char source, char middle, char destination) {
        if (disk == 0) {
            System.out.println("Plate " + disk + " from " + source + " to " + destination);
            return;
        }
        solve(disk - 1, source, destination, middle);

        System.out.println("Plate " + disk + " from " + source + " to " + destination);

        solve(disk - 1, middle, source, destination);


    }
}
