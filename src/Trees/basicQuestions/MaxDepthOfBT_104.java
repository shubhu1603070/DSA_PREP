package Trees.basicQuestions;

import Trees.TreeNode;

public class MaxDepthOfBT_104 {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
