import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhoucheng on 11/24/17.
 */
public class UniqueBinarySearchTreeTwo {
    public List<TreeNode> generateTrees(int n) {
        List<List<TreeNode>> lists = new LinkedList<>();
        if(n <= 0) return new LinkedList<>();
        // initialize with n = 0, 1
        List<TreeNode> temp = new LinkedList<>();
        temp.add(null);
        lists.add(new LinkedList<>(temp));

        temp.clear();
        temp.add(new TreeNode(1));
        lists.add(new LinkedList<>(temp));



        for(int i = 2; i <= n; i++) {
            // build list for n  = i
            List<TreeNode> list = new LinkedList<>();
            for(int j = 1; j <= i; j++) {
                track(lists, list, j, 1, j-1, j+1, i);
            }
            lists.add(list);
        }

        return lists.get(n);
    }

    private void track(List<List<TreeNode>> lists, List<TreeNode> list, int c, int ls, int le, int rs, int re) {
        TreeNode node = new TreeNode(c);
        List<TreeNode> leftList = getList(lists, le-ls+1);
        List<TreeNode> rightList = getList(lists, re-rs+1);
        for(int i = 0; i < leftList.size(); i++) {
            node.left = leftList.get(i);
            for(int j = 0; j < rightList.size(); j++) {
                node.right = clone(rightList.get(j), c);
                list.add(clone(node, 0));
            }
        }
    }

    private List<TreeNode> getList(List<List<TreeNode>> lists, int n) {
        if(n <= 0) return lists.get(0);
        return lists.get(n);
    }

    private TreeNode clone(TreeNode n, int offset) {
        if (n == null) return null;
        TreeNode node = new TreeNode(n.val+offset);
        node.left = clone(n.left, offset);
        node.right = clone(n.right, offset);

        return node;
    }

}
