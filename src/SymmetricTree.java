import java.util.*;

/**
 * Created by zhoucheng on 10/16/17.
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        Map<String, Integer> h = new HashMap<>();
        List<String> l = new LinkedList<>();
        return root == null ? true : check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        } else if(left != null && right != null) {
            if(left.val == right.val) {
                return check(left.left, right.right) && check(left.right, right.left);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
