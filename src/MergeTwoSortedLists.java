/**
 * Created by zhoucheng on 7/23/17.
 */


public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // swap
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        if(l1.val > l2.val) {
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        ListNode ans = l1;
        ListNode beforeP = ans;
        ListNode p = ans.next;
        while(l2 != null) {
            if(p == null) {
                beforeP.next = new ListNode(l2.val);
                beforeP = beforeP.next;
                p = beforeP.next;
                l2 = l2.next;
            }
            else if(p.val >= l2.val) {
                beforeP.next = new ListNode(l2.val);
                beforeP = beforeP.next;
                beforeP.next = p;
                l2 = l2.next;
            } else {
                beforeP = p;
                p = p.next;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MergeTwoSortedLists solution = new MergeTwoSortedLists();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(6);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(5);
        ListNode ans = solution.mergeTwoLists(l1, l2);
        while(ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

}
