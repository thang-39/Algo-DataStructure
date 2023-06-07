import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class Main {
    public static void main(String[] args) {
//<<<<<<< HEAD
        String s = new String("hello");
//=======
        String[] billyQuotes = {"For Brutus is an honourable man",
                "Give me your hands if we be friends and Robin shall restore amends",
                "Misery acquaints a man with strange bedfellows"};
        List<String> quotes = Arrays.asList(billyQuotes);

        List<String> words = quotes.stream()
                .flatMap(line -> Stream.of(line.split(" +")))
                .collect(Collectors.toList());

        long wordCount = words.size();
        double aveLength = ((double) words.stream()
                .map(String::length)
                .reduce(0, (x, y) -> {return x + y;})) / wordCount;
//        System.out.println("Average word length: " + aveLength);

//        char[] pullingTeeth = {'C', 'a', 't'};
//        String pet = new String(pullingTeeth);
//        System.out.println(pet);

//        String s1 = "AB";
//        String s2 = "CD";
//        String s3 = s1;
//        System.out.println(s1 == s3); // Same object?
//        s3 = s1 + s2;
//        System.out.println(s1 == s3); // Still same?
//        System.out.println(s1);
//        System.out.println(s3);

        String pet = "Cat";
        StringBuilder sb = new StringBuilder(pet);
        sb.append("amaran");
        String boat = sb.toString();
        System.out.println(boat);




//>>>>>>> e810ce2094721dff5fff9677f292f85ca818b086
    }
}