import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhoucheng on 9/2/17.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) { return; }
        else if(remain == 0) { list.add(new ArrayList<>(tempList)); }
        // remain > 0
        else {
            for(int i = start; i < nums.length; i++) {
                tempList.add(nums[i]);
                List<Integer> newTemp = tempList;
                backtrack(list, newTemp, nums, remain-nums[i], i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }


    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        CombinationSum solution = new CombinationSum();
        List<List<Integer>> ans = solution.combinationSum(candidates, target);
        for(int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}
