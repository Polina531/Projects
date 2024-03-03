import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Slicing {

    
    static public String[] slicing(String text) {
        return text.split(" ");
    }
    
    public static int wordCount(String x) {
        String[] a = (slicing(x));
        List<String> charsToExclude = new ArrayList<>
                (Arrays.asList(".", ",", ";", ":", "\"", "'", "''", "\"\""));
        Predicate<String> garbage = charsToExclude::contains;
        
        long counter = Arrays.stream(a)
                .filter(garbage.negate())
                .count();

        return (int) counter;
    }
    
}