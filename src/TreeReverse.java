/**
 * Created by zhoucheng on 9/3/17.
 */
public class TreeReverse {
    public TreeNode treeReverse(TreeNode tree) {
        if(tree != null) {
            TreeNode temp = tree.left;
            tree.left = treeReverse(tree.right);
            tree.right = treeReverse(temp);
        }
        return tree;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        TreeReverse solution = new TreeReverse();
        TreeTraverse tra = new TreeTraverse();

        System.out.println("in order");
        tra.inOrder(root);
        System.out.println("end of in order");

        System.out.println("reverse in order");
        tra.inOrder(solution.treeReverse(root));
        System.out.println("end of reverse in order");

        solution.treeReverse(root);
    }
}
