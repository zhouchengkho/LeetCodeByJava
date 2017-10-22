import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by zhoucheng on 10/21/17.
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ls = new ArrayList<>();
        if(root == null) return ls;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int count = 1;
        int countLast = 0;
        while(!q.isEmpty()) {
            countLast = count;
            count = 0;
            List<Integer> t = new ArrayList<>();
            for(int i = 0; i < countLast; i++) {
                TreeNode n = q.poll();
                t.add(n.val);
                if(n.left != null) {
                    q.add(n.left);
                    count++;
                }
                if(n.right != null) {
                    q.add(n.right);
                    count++;
                }
            }
            ls.add(new ArrayList<>(t));
        }
        return ls;
    }
}
