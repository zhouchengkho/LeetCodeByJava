import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by zhoucheng on 1/3/18.
 */
public class SubarrayProductsLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        List<Integer> q = new LinkedList<>();
        String s = "abc";
        int a = s.length();
        long p = 1;
        int i = 0;
        int j = 0;
        int total = 0;
        while(j <= nums.length - 1){
            p *= nums[j];
            while(i <= j && p >= k){
                p /= nums[i];
                i++;
            }
            total += (j - i + 1);
            j++;
        }
        return total;
    }
}
