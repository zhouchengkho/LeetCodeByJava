import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhoucheng on 10/22/17.
 */
public class CombinationSumThree {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        List<List<Integer>> ls = new LinkedList<>();
        track(ls, new LinkedList<>(), nums, 0, k, n);
        return ls;
    }

    private void track(List<List<Integer>> ls, List<Integer> t, int[] nums, int pos, int k, int n) {
        if(t.size() == k) {
            if(computeSum(t) == n) {
                ls.add(new LinkedList<>(t));
            }
        } else if (t.size() < k && computeSum(t) < n) {
            for(int i = pos; i < nums.length; i++) {
                t.add(nums[i]);
                track(ls, t, nums, i+1, k, n);
                t.remove(t.size() - 1);
            }
        }
    }

    private int computeSum(List<Integer> t) {
        int sum = 0;
        for(int i = 0; i < t.size(); i++) {
            sum+=t.get(i);
        }
        return sum;
    }
}
