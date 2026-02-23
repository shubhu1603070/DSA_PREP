package Trees.PathProblems;

import Trees.TreeNode;

public class BinaryTreeMaximumPathSum_124 {

    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode node) {
        if(node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        int leftRightMax = Math.max(left, right);
        int nodeMax = Math.max(node.val,leftRightMax+node.val);
        int allMax = Math.max(nodeMax,left+right+node.val);
        max = Math.max(max,allMax);
        return nodeMax; // This is because we have to take any one of the left / right / node.val
                        // (if node.val is greater than use that only if left + node.val / node.val+right whichever
                        //  is greater we'll consider that one)
    }

}
