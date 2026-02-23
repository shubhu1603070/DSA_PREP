package newLearning.Recursion;

import java.util.Objects;

public class Problem_2487 {
    public ListNode removeNodes(ListNode head) {
        return solve(head);
    }

    // [5 -> 2 -> 13 -> 3 -> 8]

    private ListNode solve(ListNode head) {
        if(head == null) return null;
        head.next = solve(head.next);
        if(Objects.nonNull(head.next) && head.next.val > head.val)
            return head.next;
        return head;
    }

    private void dfs(ListNode node,ListNode res){
        if(Objects.isNull(node)) return;
        if(Objects.nonNull(node.next) && node.next.val > node.val){
            if(Objects.isNull(res)){
                res = new ListNode(node.next.val);
            }else{
                res.next = new ListNode(node.next.val);
            }
            res = res.next;
        }
        dfs(node.next,res);
    }
}
