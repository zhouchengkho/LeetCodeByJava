import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length-1;
        if(nums.length <= 1) {
            return;
        }

        // find i-1
        for(;i>=1;i--) {
            if(nums[i-1] < nums[i]) {
                break;
            }
        }

        if(i!=0) {
            // swap i-1
            for(int j = nums.length-1; j >= i-1; j--) {
                if(nums[i-1] < nums[j]) {
                    // swap i-1, j
                    int t = nums[i-1];
                    nums[i-1] = nums[j];
                    nums[j] = t;
                    break;
                }
            }
        }

        // sort
        int[] next = Arrays.copyOfRange(nums, i, nums.length);
        Arrays.sort(next);
        int offset = nums.length - next.length;
        for(int j = 0; j <= next.length-1 ;j++) {
            nums[offset+j] = next[j];
        }
    }



    public static void main(String[] args) {
        NextPermutation solution = new NextPermutation();
        int[] nums = {1, 2, 3};
        solution.nextPermutation(nums);
        System.out.println("result");
        for(int i = 0; i < nums.length;i++) {
            System.out.println(nums[i]);
        }
    }
}
