import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhoucheng on 10/21/17.
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ls = new ArrayList<>();
        if(root == null) return ls;
        List<TreeNode> storage = new LinkedList<>();
        storage.add(root);
        boolean fromLeft = true;
        while(!storage.isEmpty()) {
            List<Integer> t = new LinkedList<>();
            List<TreeNode> tempNodes = new LinkedList<>();
            int size = storage.size();
            for(int i = 0; i < size; i++) {
                TreeNode n = storage.get(i);
                if(n.left != null) tempNodes.add(n.left);
                if(n.right != null) tempNodes.add(n.right);
            }
            if(fromLeft) {
                for(int i = 0; i < size; i++) {
                    t.add(storage.get(i).val);
                }
                fromLeft = false;
            } else {
                for(int i = size - 1; i >= 0; i--) {
                    t.add(storage.get(i).val);
                }
                fromLeft = true;
            }
            storage = tempNodes;
            ls.add(t);
        }
        return ls;
    }
}
