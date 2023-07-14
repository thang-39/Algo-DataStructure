package Test;
import java. io.*;
public class testhacker {


        public static void main (String arg[]) throws IOException {
            String str1, str2, str=null;
            File file1 = new File("D:\\Code\\github\\CodeWars\\src\\file1.txt");
            File file2 = new File ("D:\\Code\\github\\CodeWars\\src\\file2.txt");
            BufferedReader br1 = new BufferedReader (new FileReader (file1)) ;
            BufferedReader br2 = new BufferedReader (new FileReader (file2)) ;
            while ((str1 = br1. readLine())!= null) {
                str2 = br2. readLine();
                if (str2 != null) {
                    str=str1+" "+str2;
                    System.out.println(str);
                }
            }
            br1. close();
        }
}
