package CodeWars;

public class CreditCardMask {
    public static String maskify(String str) {
        StringBuilder string = new StringBuilder(str);
        for (int i = 0; i<str.length()-4; i++) {
            string.replace(i,i+1,"#");
        }

        return string.toString();
    }
}
