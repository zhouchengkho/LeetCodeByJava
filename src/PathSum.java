/**
 * Created by zhoucheng on 10/22/17.
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return has;
        if(root.val == sum && isLeaf(root)) return true;
        track(root, root.val, sum);
        return has;
    }

    boolean has = false;

    private void track(TreeNode node, int current, int target) {
        if(node != null && !has) {
            if(node.left != null) {
                handle(node.left, current, target);
            }
            if(node.right != null) {
                handle(node.right, current, target);
            }
        }
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private void handle(TreeNode node, int current, int target) {
        if(node.val + current == target && isLeaf(node)) {
            has = true;
            return;
        } else {
            track(node, current + node.val, target);
        }
    }
}
