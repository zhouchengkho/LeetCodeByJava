import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhoucheng on 11/25/17.
 */
public class MaximumXorOfTwoNumbersInArray {
    public int findMaximumXOR(int[] nums) {
        if (nums.length < 2) return 0;

        /**
         idea:
         start by trying to set the highest bit
         if can set, then continue to try to set the next most significant bit
         until all bits are decided, then max is decided
         */

        int max = 0;
        int mask = 0;

        for(int i = 31; i >= 0; i--) {
            mask = mask | (1 << i);

            Set<Integer> set = new HashSet<>();

            // reverse left, ignore right
            for(int j = 0; j < nums.length; j++) {
                set.add(mask & nums[j]);
            }

            int tryToSet = max | (1 << i);
            for(int left : set) {
                if(set.contains(left ^ tryToSet)) {
                    max = tryToSet;
                }
            }
        }
        return max;
    }
}
