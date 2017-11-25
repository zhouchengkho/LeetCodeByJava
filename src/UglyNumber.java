import java.util.Arrays;

/**
 * Created by zhoucheng on 11/11/17.
 */
public class UglyNumber {
    public boolean isUgly(int num) {
        if(num == 1) return true;
        if(num < 1) return false;
        track(num);
        return ugly;
    }
    boolean ugly = false;
    int[] factors = {2, 3, 5};

    public void track(int num) {
        if(num == 1) ugly = true;
        if (ugly) return;
        for(int i = 0; i < factors.length; i++) {
            if (num%factors[i] == 0) {
                track(num/factors[i]);
            }
        }
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n<=1) return 1;
        int[] nums = new int[n];

        int[] marks = new int[primes.length];
        Arrays.fill(marks, 0);
        nums[0] = 1;
        for(int i = 1; i < n; i++) {
            next(nums, i, marks, primes);
        }
        return nums[n-1];
    }

    private void next(int[] nums, int pos, int[] marks, int[] primes) {
        int[] chooseList = new int[primes.length];
        for(int i = 0; i < primes.length; i++) {
            chooseList[i] = nums[marks[i]] * primes[i];
        }

        int min = nums[pos-1];
        int nextNumber = Integer.MAX_VALUE;
        for(int i = 0; i < primes.length; i++) {
            if(chooseList[i] < nextNumber && chooseList[i] > min) {
                nextNumber = chooseList[i];
            }
        }

        for(int i = 0; i < primes.length; i++) {
            if(chooseList[i] == nextNumber)
                marks[i]++;
        }
        nums[pos] = nextNumber;
    }
}
