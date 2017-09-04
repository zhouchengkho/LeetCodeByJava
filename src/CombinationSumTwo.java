import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhoucheng on 9/3/17.
 */
public class CombinationSumTwo {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] candidates, int remain, int start) {
        if(remain == 0 && !list.contains(tempList)) {list.add(new ArrayList<>(tempList));}
        else if(remain < 0) {return;}
        else {
            // remain > 0
            for(int i = start;i < candidates.length; i++) {
                tempList.add(candidates[i]);
                backtrack(list, tempList, candidates, remain-candidates[i], i+1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        CombinationSumTwo solution = new CombinationSumTwo();
        List<List<Integer>> ans = solution.combinationSum2(candidates, target);
        for(int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}
