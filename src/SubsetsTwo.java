import java.util.*;

/**
 * Created by zhoucheng on 10/10/17.
 */
public class SubsetsTwo {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<>();
        track(ls, new ArrayList<>(), nums, 0);
        return ls;
    }

    private void track(List<List<Integer>> ls, List<Integer> temp, int[] nums, int pos) {
        ls.add(new ArrayList<>(temp));
        Map<Integer, Integer> m = new HashMap<>();
        for(int i = pos; i < nums.length; i++) {
            if(!m.containsKey(nums[i])) {
                m.put(nums[i], 0);
                temp.add(nums[i]);
                track(ls, temp, nums, i+1);
                temp.remove(temp.size() - 1);
            } else {
                // do nothing
            }
        }
    }
}
