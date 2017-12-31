import java.util.Stack;

/**
 * Created by zhoucheng on 12/30/17.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        ListNode res = new ListNode(0);
        ListNode head = res;
        int carry = 0;
        while(!s1.isEmpty() || !s2.isEmpty()) {
            int sum = 0;
            if(!s1.isEmpty()) sum+=s1.pop();
            if(!s2.isEmpty()) sum+=s2.pop();
            sum+=carry;
            carry = sum >= 10 ? 1 : 0;
            sum%=10;
            res.val = sum;
            ListNode t = new ListNode(0);
            t.next = res;
            res = t;
        }
        if(carry == 1 && res != null) {
            res.val = 1;
            return res;
        } else {
            return res == null ? res : res.next;
        }
    }
}
