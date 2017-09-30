/**
 * Created by zhoucheng on 9/30/17.
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int count0 = 0;
        int count1 = 0;
        for(int i = 0; i<nums.length;i++) {
            switch (nums[i]) {
                case 0:
                    count0++;
                    break;
                case 1:
                    count1++;
                    break;
                default:
                    break;
            }
        }
        for(int i = 0; i<nums.length;i++) {
            if(count0 > 0) {
                nums[i] = 0;
                count0--;
            } else if(count1 > 0) {
                nums[i] = 1;
                count1--;
            } else {
                nums[i] = 2;
            }
        }
    }
}
