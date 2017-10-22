/**
 * Created by zhoucheng on 10/21/17.
 */
public class SumOfLeftLeaves {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        track(root, false);
        return sum;
    }

    private void track(TreeNode node, boolean l) {
        if(node != null) {
            if(leftLeaf(node, l)) {
                sum+=node.val;
            }
            track(node.left, true);
            track(node.right, false);
        }
    }

    private boolean leftLeaf(TreeNode n, boolean l) {
        return n.left == null && n.right == null && l;
    }
}
