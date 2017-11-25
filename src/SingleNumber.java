/**
 * Created by zhoucheng on 11/25/17.
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        if (nums.length == 0) return 0;
        int single = nums[0];
        for(int i = 1; i < nums.length; i++) {
            single^=nums[i];
        }
        return single;
    }
}
