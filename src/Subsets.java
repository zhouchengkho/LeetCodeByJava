import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Subsets {
    List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();
        track(nums, ls, new ArrayList<>(), 0);
        return ls;
    }

    void track(int[] nums, List<List<Integer>> ls, List<Integer> temp, int pos) {
        ls.add(new ArrayList<>(temp));
        for(int i = pos; i < nums.length; i++) {
            temp.add(nums[i]);
            track(nums, ls, temp, i+1);
            temp.remove(temp.size() - 1);
        }
    }
}
