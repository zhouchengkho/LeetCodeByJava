/**
 * Created by zhoucheng on 10/21/17.
 */
public class SecondMinimumNodeInABinaryTree {
    public int findSecondMinimumValue(TreeNode root) {
        return track(root);
    }

    private int track(TreeNode node) {
        if(node != null) {
            if(node.left != null && node.right != null) {
                if(node.left.val == node.right.val) {
                    int l = track(node.left);
                    int r = track(node.right);
                    if(l == -1 || r == -1) return Math.max(l, r);
                    return Math.min(l, r);
                } else if(node.left.val != node.val) {
                    int r = track(node.right);
                    return r == -1 ? node.left.val : Math.min(r, node.left.val);
                } else {
                    int l = track(node.left);
                    return l == -1 ? node.right.val : Math.min(l, node.right.val);
                }
            }
        }
        return -1;
    }
}
