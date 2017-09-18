import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhoucheng on 9/13/17.
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();
        backtrack(ls, new ArrayList<>(), nums);
        return ls;
    }
    private void backtrack(List<List<Integer>> ls, List<Integer> tempList, int[] nums) {
        if(tempList.size() == nums.length) {
            ls.add(new ArrayList<>(tempList));
        } else {
            for(int i = 0; i < nums.length; i++) {
                if(tempList.contains(nums[i])) continue;
                tempList.add(nums[i]);
                backtrack(ls, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Permutations solution = new Permutations();
        System.out.println(solution.permute(nums));
    }

}
