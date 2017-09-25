/**
 * Created by zhoucheng on 9/25/17.
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(k == 0 || head == null || head.next == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        int len = 1;
        while(fast.next != null) {
            fast = fast.next;
            len++;
        }
        k = k%len;
        fast.next = head;
        int diff = len - 1;
        while(diff <= k) {
            slow = slow.next;
            diff++;
        }
        ListNode newHead = slow;
        slow.next = null;
        return newHead;
    }
}
