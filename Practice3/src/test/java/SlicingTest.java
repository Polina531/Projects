import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SlicingTest {
    
    
    @Test
    public void test1() {
        assertEquals(3, (Slicing.wordCount("fish meat sucks.")));
        assertEquals(5, (Slicing.wordCount("one two : three ' five , eleven")));
    }
    
    @Test
    public void test2() {
        String a = (Slicing.wordInstanceCount("Old bull who eats young grass grass"));
        String b = (Slicing.wordInstanceCount("Old bull. who,, eats, young'' grass\" grass"));
        assertEquals(a,b);
    
    }
}
