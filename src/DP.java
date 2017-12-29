import java.util.Arrays;

/**
 * Created by zhoucheng on 12/3/17.
 */
public class DP {
    public int minimumDeleteSum(String s1, String s2) {

        int s[][] = new int[s1.length()+1][s2.length()+1];


        for(int i = 0; i <= s1.length(); i++) {
            for(int j = 0; j <= s2.length(); j++) {
                if(i == 0 && j == 0) {
                    s[i][j] = 0;
                    continue;
                } else if(i == 0) {
                    s[i][j] = s[i][j-1] + s2.charAt(j-1);
                    continue;
                } else if(j == 0) {
                    s[i][j] = s[i-1][j] + s1.charAt(i-1);
                    continue;
                }

                s[i][j] = s[i-1][j-1];
                if(s1.charAt(i-1) != s2.charAt(j-1)) {
                    s[i][j] = s[i-1][j-1] + (s1.charAt(i-1) + s2.charAt(j-1));
                }
                if(s[i-1][j] + s1.charAt(i-1) < s[i][j]) s[i][j] = s[i-1][j] + s1.charAt(i-1);
                if(s[i][j-1] + s2.charAt(j-1) < s[i][j]) s[i][j] = s[i][j-1] + s2.charAt(j-1);

            }
        }

        return s[s1.length()][s2.length()];

    }

    public int minCostClimbingStairs(int[] cost) {
        if(cost.length < 2) return 0;
        int[] s = new int[cost.length + 1];

        s[1] = cost[0];
        for(int i = 2; i < cost.length; i++) {
            s[i] = Math.min(s[i-1] + cost[i-1], s[i-2] + cost[i-1]);
        }
        s[cost.length] = Math.min(s[cost.length - 1], s[cost.length - 2] + cost[cost.length - 1]);
        return s[cost.length];
    }

    public int deleteAndEarn(int[] nums) {
        int[][] s = new int[nums.length+1][2];

        Arrays.sort(nums);
        for(int i = 1; i <= nums.length; i++) {
            if(i == 1) {
                s[i][0] = 0;
                s[i][1] = nums[i-1];
                continue;
            }
            if(nums[i-1] == nums[i-2] + 1) {
                s[i][0] = Math.max(s[i-1][0], s[i-1][1]);
                s[i][1] = s[i-1][0] + nums[i-1];
            } else if (nums[i-1] == nums[i-2]) {
                s[i][0] = s[i-1][0];
                s[i][1] = s[i-1][1] + nums[i-1];
            } else {
                // no relation
                s[i][0] = Math.max(s[i-1][0], s[i-1][1]);
                s[i][1] = Math.max(s[i-1][0], s[i-1][1]) + nums[i-1];
            }
        }

        return Math.max(s[nums.length][0], s[nums.length][1]);
    }
}
