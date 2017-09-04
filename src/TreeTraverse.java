/**
 * Created by zhoucheng on 9/3/17.
 */
public class TreeTraverse {
    // in order
    public void inOrder(TreeNode node) {
        if(node != null) {
            inOrder(node.left);
            // visit current node
            System.out.println(node.val);
            inOrder(node.right);
        }
    }
    // pre order
    public void preOrder(TreeNode node) {
        if(node != null) {
            // visit current node
            System.out.println(node.val);
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    // post order
    public void postOrder(TreeNode node) {
        if(node != null) {
            // visit current node
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.val);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        TreeTraverse solution = new TreeTraverse();
        System.out.println("in order");
        solution.inOrder(root);
        System.out.println("end of in order");

        System.out.println("pre order");
        solution.preOrder(root);
        System.out.println("end of pre order");

        System.out.println("post order");
        solution.postOrder(root);
        System.out.println("end of post order");
    }
}
