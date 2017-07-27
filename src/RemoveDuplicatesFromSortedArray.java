/**
 * Created by zhoucheng on 7/27/17.
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int i = nums.length > 0 ? 1 : 0;
        for (int n : nums) {
            if (n > nums[i-1]) {
                nums[i++] = n;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();
        int[] nums = {1, 1, 2};
        System.out.println(solution.removeDuplicates(nums));
    }
}
