/**
 * Created by zhoucheng on 11/9/17.
 */
public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {

        return track(head, null);

    }


    private TreeNode track(ListNode start, ListNode end) {
        if (start == end) return null;

        ListNode slow = start;
        ListNode fast = start;
        while(fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode node = new TreeNode(slow.val);
        node.left = track(start, slow);
        node.right = track(slow.next, end);
        return node;
    }

}
