import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.StreamSupport;

/**
 * Created by zhoucheng on 7/18/17.
 */
public class FourSum {


    List<List<Integer>> addList(List<List<Integer>> ans, int[] list) {
        Arrays.sort(list);
        List<Integer> lst =  new ArrayList<>();
        for(int i : list) {
            lst.add(i);
        }
        if(!ans.contains(lst)) {
            ans.add(lst);
        }
        return ans;
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if(len < 4) {
            return ans;
        }
        Arrays.sort(nums);
        // int min = nums[0] + nums[1] + nums[len-1] + nums[len-2] - target;
        // int[] lst = {nums[0], nums[1], nums[len-1], nums[len-2]};
        // ans = addList(ans, lst);
        for(int i = 0; i < len-2; i++) {
            for(int j = len-1; j >= 2; j--) {
                int bottom = nums[i];
                int top = nums[j];
                int lo = i+1;
                int hi = j-1;
                while(lo < hi) {
                    int newMin = bottom + top + nums[lo] + nums[hi] - target;
                    if(newMin == 0) {
                        int[] ls = {bottom, nums[lo], nums[hi], top};
                        ans = addList(ans, ls);
                        lo++;
                        hi--;
                    }
                    if(newMin < 0) {
                        lo++;
                    }
                    else if(newMin > 0){
                        hi--;
                    }
                }
                }
            }
        return ans;
    }

    public static void main(String[] args) {
        // write your code here
        FourSum solution = new FourSum();
        int[] nums = {-3,-1,0,2,4,5};
        int target = 2;
        System.out.println(solution.fourSum(nums, target));
    }
}
