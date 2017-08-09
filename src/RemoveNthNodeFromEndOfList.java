/**
 * Created by zhoucheng on 8/2/17.
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        int count = 0;
        while(fast.next != null) {
            fast = fast.next;
            if(count < n) {
                count++;
            } else {
                slow = slow.next;
            }
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList solution = new RemoveNthNodeFromEndOfList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head = solution.removeNthFromEnd(head, 1);
        while(head !=null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
