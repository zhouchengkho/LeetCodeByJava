/**
 * Created by zhoucheng on 10/17/17.
 */
public class LongestUniValuePath {
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        track(root);
        return max;
    }

    int max = 0;

    private int track(TreeNode node) {
        int l = node.left == null ? 0 : track(node.left);
        int r = node.right == null ? 0 : track(node.right);
        int conL = node.left != null && node.left.val == node.val ? l+1 : 0;
        int conR = node.right != null && node.right.val == node.val ? r+1 : 0;
        max = Math.max(max, conL+conR);
        return Math.max(conL, conR);
    }
}
