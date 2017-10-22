import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhoucheng on 10/22/17.
 */
public class PathSumTwo {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ls = new LinkedList<>();
        track(ls, new LinkedList<>(), root, sum);
        return ls;
    }

    private void track(List<List<Integer>> ls, List<Integer> t, TreeNode node, int target) {
        if(node != null) {
            if(isLeaf(node)) {
                t.add(node.val);
                if(computeSum(t) == target) {
                    ls.add(new LinkedList<>(t));
                }
                t.remove(t.size() - 1);
            } else {
                t.add(node.val);
                track(ls, t, node.left, target);
                track(ls, t, node.right, target);
                t.remove(t.size() - 1);
            }
        }
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private int computeSum(List<Integer> t) {
        int sum = 0;
        for(int i = 0; i < t.size(); i++) {
            sum+=t.get(i);
        }
        return sum;
    }
}
