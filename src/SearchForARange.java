/**
 * Created by zhoucheng on 9/5/17.
 */
public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        int[] ans = {-1, -1};
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            if(nums[mid] > target) {
                hi = mid - 1;
            } else if(nums[mid] < target){
                lo = mid + 1;
            } else {
                // found, search neighbour
                int min = mid;
                int max = mid;
                while(min-1 >= 0 && nums[min-1] == nums[mid]) {min--;}
                while(max+1 <= nums.length - 1 && nums[max+1] == nums[mid]) {max++;}
                System.out.println("target pos: "+min+ " "+max);
                ans[0] = min;
                ans[1] = max;
                return ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SearchForARange solution = new SearchForARange();
        int[] nums = {8, 8, 8, 8};
        int target = 8;
        System.out.println(solution.searchRange(nums, target).toString());
    }
}
