/**
 * Created by zhoucheng on 11/29/17.
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        return majority(nums, 0, nums.length-1).num;
    }

    class NumCount {
        int num;
        int count;
        NumCount(int n, int c) {
            num = n;
            count = c;
        }
    }
    private NumCount majority(int[] nums, int s, int e) {

        if(e - s == 0) return new NumCount(nums[s], 1);
        int mid = (s+e)/2;
        NumCount m1 = majority(nums, s, mid);
        NumCount m2 = majority(nums, mid + 1, e);

        if(m1.num == m2.num) return new NumCount(m1.num, m1.count+m2.count);
        int count1 = findCount(nums, mid+1, e, m1.num);
        int count2 = findCount(nums, s,   mid, m2.num);
        if(m1.count + count1 >  m2.count + count2) return new NumCount(m1.num, m1.count+count1);
        return new NumCount(m2.num, m2.count+count2);
    }

    private int findCount(int[] nums, int s, int e, int target) {
        int count = 0;
        for(int i = s; i <= e; i++) {
            if(nums[i] == target) count++;
        }
        return count;
    }
}
