/**
 * Created by zhoucheng on 10/22/17.
 */
public class ConstructBinaryTreeFromPostOrderAndInOrderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return track(postorder.length - 1, 0, postorder.length - 1, postorder, inorder);
    }

    private TreeNode track(int postRootIndex, int s, int e, int[] postorder, int[] inorder) {
        if (s > e || postRootIndex < 0 || postRootIndex > postorder.length - 1) return null;

        TreeNode root = new TreeNode(postorder[postRootIndex]);

        int inRootIndex = 0;
        for (int i = s; i <= e; i++) {
            if (postorder[postRootIndex] == inorder[i]) {
                inRootIndex = i;
            }
        }

        root.left = track(postRootIndex - (e - inRootIndex) - 1, s, inRootIndex - 1, postorder, inorder);
        root.right = track(postRootIndex - 1, inRootIndex + 1, e, postorder, inorder);
        return root;
    }

}
