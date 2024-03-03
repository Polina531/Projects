import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.function.Predicate.not;

public class Slicing {

    
    static public String[] slicing(String text) {
        return text.split(" ");
    }
    
    public static int wordCount(String x) {
        String[] a = (slicing(x));
        
        List<String> charsToExclude = new ArrayList<>
                (Arrays.asList(new String[]{".", ",", ";", ":", "\"", "'", "\"\""}));
        long garbage = Arrays.stream(a)
                .filter(charsToExclude::contains)
                .count();

        return (int) (a.length-garbage);
    }
    
}