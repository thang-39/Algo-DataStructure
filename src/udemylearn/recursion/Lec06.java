package udemylearn.recursion;

public class Lec06 {
    public static void main(String[] args) {
        System.out.println(reverse("Thang"));
        System.out.println("thang".substring(1));
    }
    public static String reverse(String s) {
        if (s.equals("")) return s;

        return reverse(s.substring(1)) + s.charAt(0);
    }
}
