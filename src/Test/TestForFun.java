package Test;

import java.util.*;
import java.util.stream.Stream;

public class TestForFun {
    public static void main(String[] args) {
        // New, empty map
        Map<String,Integer> m = new HashMap<>();
// Immutable Map containing a single key/value pair
        Map<String,Integer> singleton = Collections.singletonMap("test", -1);
// Note this rarely used syntax to explicitly specify the parameter
// types of the generic emptyMap method. The returned map is immutable
        Map<String,Integer> empty = Collections.<String,Integer>emptyMap();
// Populate the map using the put method to define mappings
// from array elements to the index at which each element appears
        String[] words = { "this", "is", "a", "test" };
        for(int i = 0; i < words.length; i++) {
            m.put(words[i], i); // Note autoboxing of int to Integer
        }
// Each key must map to a single value. But keys may map to the
// same value
        for(int i = 0; i < words.length; i++) {
            m.put(words[i].toUpperCase(), i);
        }
// The putAll() method copies mappings from another Map
        m.putAll(singleton);
// Query the mappings with the get() method
//        for(int i = 0; i < words.length; i++) {
//            if (m.get(words[i]) != i) throw new AssertionError();
//        }
// Key and value membership testing
        m.containsKey(words[0]); // true
        m.containsValue(words.length); // false
// Map keys, values, and entries can be viewed as collections
        Set<String> keys = m.keySet();
        Collection<Integer> values = m.values();
        Set<Map.Entry<String,Integer>> entries = m.entrySet();

        System.out.printf("Map: %s%nKeys: %s%nValues: %s%nEntries: %s%n",
                m, keys, values, entries);


        for(Map.Entry<String,Integer> pair : m.entrySet()) {
// Print out mappings
            System.out.printf("'%s' ==> %d%n", pair.getKey(), pair.getValue());
// And increment the value of each Entry
            pair.setValue(pair.getValue() + 1);
        }

        double sumPrimes=((double) Stream.of(2,3,5,7,11,13,17,19,23)
                .reduce(0,(x,y) -> {return x+y;}));
        System.out.println("Sumofsomeprimes:"+sumPrimes);
        System.out.println(2+3+5+7+11+13+17+19+23);

    }
}
