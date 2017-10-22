/**
 * Created by zhoucheng on 10/17/17.
 */
public class TrimABinarySearchTree {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null) return root;
        root = check(L, R, root);
        return root;
    }

    private TreeNode check(int L, int R, TreeNode node) {
        if(node != null) {
            if(node.val < L || node.val > R) {
                if(node.val < L) {
                    return check(L, R, node.right);
                } else if(node.val > R) {
                    return check(L, R, node.left);
                }
            } else {
                // fit
                node.left = check(L, R, node.left);
                node.right = check(L, R, node.right);
                return node;
            }
        }
        return null;
    }
}
