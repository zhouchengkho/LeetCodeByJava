/**
 * Created by zhoucheng on 10/10/17.
 */
public class RemoveDuplicatesFromSortedListTwo {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode p = head;

        while(p != null) {
            int c = p.val;
            if(p.next != null && p.next.val == c) {
                // duplicates
                while(p.next != null && p.next.val == c) {
                    p = p.next;
                }
                // ready to connect
                prev.next = p.next;
                p = p.next;
            } else {
                prev = prev.next;
                p = p.next;
            }
        }
        return dummy.next;
    }
}
