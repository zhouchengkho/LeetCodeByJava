import java.util.List;

/**
 * Created by zhoucheng on 9/30/17.
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode current = head;
        ListNode next = current.next;
        while(next != null) {
            if(current.val == next.val) {
                current.next = mvUntilDiff(current);
            }
            current = current.next;
            next = current != null ? current.next : null;
        }
        return head;
    }

    private ListNode mvUntilDiff(ListNode current) {
        ListNode p = current;
        while(p!=null && p.val == current.val) {
            p = p.next;
        }
        return p;
    }
}
