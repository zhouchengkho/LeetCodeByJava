/**
 * Created by zhoucheng on 10/21/17.
 */
public class MaximumDepthOfBinaryTree {
    int max = 0;
    public int maxDepth(TreeNode root) {
        track(root, 0);
        return max;
    }

    private void track(TreeNode node, int ch) {
        max = Math.max(max, ch);
        if(node != null) {
            track(node.left, ch + 1);
            track(node.right, ch + 1);
        }
    }
}
