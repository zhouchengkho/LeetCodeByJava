import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhoucheng on 11/29/17.
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        // int min = Integer.MIN_VALUE;
        // int max = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            // min = Math.max(min, nums[i]);
            // max = Math.min(max, nums[i]);
            set.add(nums[i]);
        }

        int longest = 0;
        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i]-1)) continue;
            int start = nums[i];
            int l = 0;
            while(set.contains(start)) {
                l++;
                start++;
            }
            longest = Math.max(longest, l);
        }
        return longest;
    }





}
