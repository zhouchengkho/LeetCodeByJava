import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhoucheng on 10/15/17.
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        inorderValidate(root, ls);
        return valid;
    }

    TreeNode pre;
    boolean valid = true;
    private void inorderValidate(TreeNode node, List<Integer> ls) {
        if(node != null && valid) {
            pre = node;
            inorderValidate(node.left, ls);
            if(ls.size() > 0 && ls.get(ls.size() -1 ) >= node.val) {
                valid = false;
            }
            ls.add(node.val);
            inorderValidate(node.right, ls);
        }
    }
}
