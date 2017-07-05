import java.util.*;
import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int min = nums[0] + nums[1] + nums[len-1] - target;
        for(int i = 0;i<=len-1;i++) {
            int j = i+1;
            int k = len-1;
            if(min == 0) {
                break;
            }
            while(j < k) {
                int newMin = nums[i] + nums[j] + nums[k] - target;
                if(newMin < 0) {
                    if(Math.abs(newMin) < Math.abs(min)) {
                        min = newMin;
                    }
                    j++;
                } else if (newMin > 0) {
                    if(Math.abs(newMin) < Math.abs(min)) {
                        min = newMin;
                    }
                    k--;
                } else {
                    min = 0;
                    break;
                }
            }
        }
        return min+target;
    }
    
    public static void main(String[] args) {
        ThreeSumClosest solution = new ThreeSumClosest();
        int[] nums ={-1, 2, 1, -4, 0};
        int target = 1;
        System.out.println(solution.threeSumClosest(nums, target));
    }
}
