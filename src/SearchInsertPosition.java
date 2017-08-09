import java.util.Arrays;

/**
 * Created by zhoucheng on 8/2/17.
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        Arrays.sort(nums);
        if(nums.length == 0 || target < nums[0]) {
            return 0;
        }
        if(target > nums[nums.length-1]) {
            return nums.length;
        }
        for(int i = 0; i < nums.length; i++) {
            if(target <= nums[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInsertPosition solution = new SearchInsertPosition();
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        System.out.println(solution.searchInsert(nums, target));
    }
}
