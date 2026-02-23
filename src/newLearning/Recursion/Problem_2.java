package newLearning.Recursion;

import java.util.Objects;

public class Problem_2 {

    ListNode result = new ListNode(-1);
    int reminder = 0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode finalNode = result;
        solve(l1,l2);
        return finalNode.next;
    }

    private void solve(ListNode l1, ListNode l2){
        if(Objects.isNull(l1) && Objects.nonNull(l2)){
            result.next = new ListNode(l2.val);
            addTwoNumbers(l1,l2.next);
        }else if(Objects.isNull(l2) && Objects.nonNull(l1)){
            result.next = new ListNode(l1.val);
            addTwoNumbers(l1.next,l2);
        }else if(Objects.nonNull(l1) && Objects.nonNull(l2)) {
            int add = l1.val + l2.val;
            if (reminder > 0) {
                add += reminder;
            }
            if (add > 10) {
                int div = add / 10;
                reminder = add % 10;
                result.next = new ListNode(div);
                result = result.next;
            } else {
                reminder = 0;
            }
            solve(l1.next,l2.next);
        }
    }

}
