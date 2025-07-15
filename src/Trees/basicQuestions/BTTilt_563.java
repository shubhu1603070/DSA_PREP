package Trees.basicQuestions;

import Trees.TreeNode;

public class BTTilt_563 {

    int sum = 0;
    public int findTilt(TreeNode root) {
        dfs(root);
        return sum;
    }

    private int dfs(TreeNode node){
        if(node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        int val = node.val;
        node.val = Math.abs(left-right);
        sum+=node.val;
        return left + right + val;
    }

}
