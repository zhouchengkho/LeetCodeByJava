/**
 * Created by zhoucheng on 11/9/17.
 */
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return track(nums, 0, nums.length-1);
    }

    private TreeNode track(int[] nums, int start, int end) {
        if (start>end) return null;
        int mid = (start+end)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = track(nums, start, mid-1);
        node.right = track(nums, mid+1, end);
        return node;
    }


}
