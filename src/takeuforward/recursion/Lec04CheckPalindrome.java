package takeuforward.recursion;

public class Lec04CheckPalindrome {
    public static void main(String[] args) {
        System.out.println(checkPalindrome("Thang",0));
        System.out.println(checkPalindrome("MADAM",0));
    }

    public static boolean checkPalindrome(String str, int i) {
        if (i >= str.length()/2)
            return true;
        if (str.charAt(i) != str.charAt(str.length() - i -1))
            return false;
        return checkPalindrome(str, i+1);
    }
}
