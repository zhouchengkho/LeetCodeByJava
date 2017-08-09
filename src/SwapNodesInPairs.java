/**
 * Created by zhoucheng on 8/1/17.
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode p = head;
        while(p!=null && p.next != null) {
            ListNode next = p.next;
            ListNode nextNext = next.next;
            int pVal = p.val;
            p.val = next.val;
            p.next = new ListNode(pVal);
            p.next.next = nextNext;
            p = p.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        SwapNodesInPairs solution = new SwapNodesInPairs();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        head = solution.swapPairs(head);
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
