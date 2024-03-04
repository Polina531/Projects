import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class BinaryThingTest {
    
    @Test
    public void binaryThingTest() {
        assertEquals(4, BinaryThing.something(new int[]{1, 1, 5, 5, 4, 6, 6}));
    }
    @Test
    public void binaryThingTest1() {
        assertEquals(1, BinaryThing.something(new int[]{1}));
    }
    @Test
    public void SlicingTest() {
        System.out.println(Arrays.toString(Slicing.slice("1 2 3 cat dog")));
    }
    
    
}
