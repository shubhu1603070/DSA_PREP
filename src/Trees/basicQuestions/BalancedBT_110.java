package Trees.basicQuestions;

import Trees.TreeNode;

public class BalancedBT_110 {

    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return this.flag;
        helper(root);
        return this.flag;
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;
        int left = helper(node.left);
        int right = helper(node.right);
        if (Math.abs(left - right) > 1 && this.flag) this.flag = false;
        return Math.max(left, right) + 1;
    }
}
