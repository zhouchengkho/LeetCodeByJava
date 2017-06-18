import java.util.*;
import java.util.Arrays;
/**
 * Created by zhoucheng on 6/18/17.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        Arrays.sort(nums);
//        int len = nums.length;
//        for(int i = 0; i< len-1;i++) {
//            int j = i+1;
//            int k = len - 1;
//            if(i > 0 && nums[i] == nums[i-1]) {
//                continue;
//            }
//            while(k>j) {
//                int sum = nums[i]+nums[j]+nums[k];
//                if(sum == 0) {
//                    List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
//                    if(!result.contains(temp))
//                    result.add(temp);
//                    j++;
//                    k--;
//                }
//                else if(sum > 0) {
//                    k--;
//                } else {
//                    j++;
//                }
//            }
//        }
//        return result;
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length-2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int lo = i+1, hi = nums.length-1, sum = 0 - nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo+1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi-1]) hi--;
                        lo++; hi--;
                    } else if (nums[lo] + nums[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(solution.threeSum(nums));
    }
}
