/**
 * Created by zhoucheng on 10/7/17.
 */
public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while ((root.val - p.val) * (root.val - q.val) > 0)
            root = p.val < root.val ? root.left : root.right;
        return root;

    }

    public static void main(String[] args) {
        LowestCommonAncestorOfABinarySearchTree sol = new LowestCommonAncestorOfABinarySearchTree();
        TreeNode r = new TreeNode(3);
        r.left = new TreeNode(1);
        r.right = new TreeNode(4);
        r.left.right = new TreeNode(2);
        System.out.println(sol.lowestCommonAncestor(r, r.left.right, r.right).val);
    }
}
