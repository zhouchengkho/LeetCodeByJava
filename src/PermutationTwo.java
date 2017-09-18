import java.util.*;

/**
 * Created by zhoucheng on 9/18/17.
 */
public class PermutationTwo {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(ls, new ArrayList<>(), nums, used);
        return ls;
    }

    private void backtrack(List<List<Integer>> ls, List<Integer> tempList, int[] nums, boolean[] used) {
        int len = nums.length;
        if(tempList.size() == len) {
            ls.add(new ArrayList<>(tempList));
        } else {
            for(int i = 0; i < len; i++) {
                if(!used[i] && !(i > 0 && nums[i] == nums[i-1] && !used[i-1])) {
                    tempList.add(nums[i]);
                    used[i] = true;
                    backtrack(ls, tempList, nums, used);
                    tempList.remove(tempList.size() - 1);
                    used[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        PermutationTwo solution = new PermutationTwo();
        int[] nums = {-1,2,-1,2,1,-1,2,1};
        System.out.println(solution.permuteUnique(nums));
    }
}
