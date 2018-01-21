/**
 * Created by zhoucheng on 1/21/18.
 */
public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(p, q, root, null);
    }

    private TreeNode dfs(TreeNode p, TreeNode q, TreeNode node, TreeNode anc) {
        if(node == null) return null;
        if(node == p) {
            if(has(node, q)) return p;
            if(has(anc, q)) return anc;

        } else if(node == q) {
            if(has(node, p)) return q;
            if(has(anc, p)) return anc;

        }
        TreeNode res = dfs(p, q, node.left, node);
        if(res != null) return res;
        return dfs(p, q, node.right, node);

    }

    private boolean has(TreeNode node, TreeNode target) {
        if(node == null) return false;
        if(node == target) return true;
        return has(node.left, target) || has(node.right, target);
    }

    public static void main(String[] args) {
        LowestCommonAncestorOfABinaryTree sol = new LowestCommonAncestorOfABinaryTree();

        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(-2);
        root.left.left.left = new TreeNode(8);
        root.left.right = new TreeNode(4);

        System.out.println(sol.lowestCommonAncestor(root, root.right, root.left.left.left).val);

    }
}
