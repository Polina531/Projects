import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Slicing {
    
    static public String[] slice(String text) {
        return text.split(" ");
    }
    
    public static int wordCount(String x) {
        String[] a = (slice(x));
        List<String> charsToExclude = new ArrayList<>
                (Arrays.asList(".", ",", ";", ":", "\"", "'", "''", "\"\"", "-", "_", "+"));
        Predicate<String> garbage = charsToExclude::contains;
        
        long counter = Arrays.stream(a)
                .filter(garbage.negate())
                .count();

        return (int) counter;
    }
    
    public static String wordInstanceCount(String x) {
        
        List<String> charsToExclude = new ArrayList<>
                (Arrays.asList(".", ",", ";", ":", "\"", "'", "-", "_", "+"));
        for (String c : charsToExclude) {
            x = x.replace(c, "");
        }
        String[] a = (slice(x));
        
        Set<String> set = new HashSet<>();
        for (String word : a) {
            set.addAll(List.of(a));
        }
        Map<String, Integer> results = new HashMap<>();
        
        int count = 0;
        for (String setWord : set) {
            for (String word : a) {
                if (word.equals(setWord)) count++;
            }
            results.put(setWord, count);
            count = 0;
        }
        return results.toString();
    }
    
}