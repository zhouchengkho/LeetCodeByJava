/**
 * Created by zhoucheng on 9/4/17.
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        if(nums.length == 0) return -1;
        while(lo < hi) {
            int mid = (lo + hi) / 2;
            if(nums[mid] > nums[hi]) {
                // pivot after mid
                lo = mid + 1;
            } else {
                // pivot before mid
                hi = mid;
            }
        }
        int pivot = lo;
        System.out.println(pivot);
        if(target >= nums[pivot] && target <= nums[nums.length - 1]) {
            lo = pivot;
            hi = nums.length - 1;
        } else {
            lo = 0;
            hi = pivot-1;
        }
        System.out.println(lo + " " + hi);
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            if(nums[mid] < target) {
                lo = mid+1;
            } else if(nums[mid] > target) {
                hi = mid-1;
            } else {
                return mid;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray();
        int[] nums = {1};
        int target = 1;
        System.out.println(solution.search(nums, target));
    }
}
