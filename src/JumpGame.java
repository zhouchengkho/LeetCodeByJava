/**
 * Created by zhoucheng on 9/23/17.
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(i>max) {return false;}
            max = Math.max(nums[i]+i,max);
        }
        return true;
    }



    public static void main(String[] args) {
        JumpGame solution = new JumpGame();
        int[] nums = {1, 2, 3};
        System.out.println(solution.canJump(nums));
    }
}
