
public class BinaryThing {

    public static int something(int[] nums) {
        var result = 0;
        
        for(var num : nums) {
            result ^= num;
        }
        
        return result;
    }
    // how does this even work
}
