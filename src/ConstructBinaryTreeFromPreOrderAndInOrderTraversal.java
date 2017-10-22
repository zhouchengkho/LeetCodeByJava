/**
 * Created by zhoucheng on 10/22/17.
 */
public class ConstructBinaryTreeFromPreOrderAndInOrderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return track(0, 0, preorder.length - 1, preorder, inorder);
    }

    public TreeNode track(int preRootIndex, int s, int e, int[] preorder, int[] inorder) {
        if(preRootIndex > inorder.length - 1 || s > e) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preRootIndex]);

        // find inorder root index
        int inRootIndex = 0;
        for(int i = s; i <= e; i++) {
            if(preorder[preRootIndex] == inorder[i]) {
                inRootIndex = i;
            }
        }

        root.left = track(preRootIndex+1, s, inRootIndex - 1, preorder, inorder);
        // finding right node index is a bit tricky, key here is compute how big the left node is, then + 1
        root.right = track(preRootIndex + inRootIndex - s + 1, inRootIndex + 1, e, preorder, inorder);
        return root;
    }
}
