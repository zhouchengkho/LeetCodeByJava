import java.util.Arrays;

/**
 * Created by zhoucheng on 10/5/17.
 */
public class RemoveDuplicatesFromSortedArrayTwo {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 1) return nums.length;
        int[] newNums = new int[nums.length];
        Arrays.fill(newNums, 0);
        newNums[0] = nums[0];
        int count = 1;
        int rep = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1]) {
                rep++;
                if(rep >= 2) {
                    continue;
                }
            } else {
                rep = 0;
            }
            newNums[count] = nums[i];
            count++;
        }
        System.arraycopy(newNums, 0, nums, 0, nums.length);
        return count;

        // another one
//        int i = 0;
//        for (int n : nums)
//            if (i < 2 || n > nums[i-2])
//                nums[i++] = n;
//        return i;
    }
}
