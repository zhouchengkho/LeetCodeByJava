/**
 * Created by zhoucheng on 7/27/17.
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for(int num : nums) {
            if(i < nums.length && num != val) {
                nums[i] = num;
                i++;
            }
        }
        return i;
    }

    public static void main(String[]  args) {
        RemoveElement solution = new RemoveElement();
        int[] nums = {2, 3, 3, 4};
        int val = 3;
        System.out.println(solution.removeElement(nums, val));
    }
}
