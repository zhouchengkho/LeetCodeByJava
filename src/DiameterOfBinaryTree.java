/**
 * Created by zhoucheng on 10/23/17.
 */
public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        dp(root);
        return max;
    }
    int max = 0;
    private int dp(TreeNode node) {
        if(node != null) {
            int left = dp(node.left);
            int right = dp(node.right);
            System.out.println("node: "+node.val+" l&r:"+left+" "+right);
            max = Math.max(max, left+right);
            return Math.max(left, right) + 1;
        }
        return 0;
    }
}
