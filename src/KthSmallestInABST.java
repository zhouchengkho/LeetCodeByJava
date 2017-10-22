import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhoucheng on 10/21/17.
 */
public class KthSmallestInABST {
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);


        return result;
    }
    int result = -1;
    int c = 0;
    private void inorder(TreeNode n, int k) {
        if(n != null) {
            inorder(n.left, k);
            c++;
            if(c == k) {
                result = n.val;
                return;
            }
            inorder(n.right, k);
        }
    }
}
