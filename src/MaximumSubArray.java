/**
 * Created by zhoucheng on 9/10/17.
 */
public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int sum = dp[0];
        for(int i = 1; i < len; i++) {
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            sum = dp[i] > sum ? dp[i] : sum;
        }
        return sum;
    }
}
