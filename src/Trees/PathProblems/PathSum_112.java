package Trees.PathProblems;

import Trees.TreeNode;

public class PathSum_112 {


    // SPACE O(1) / TIME O(N)
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root,targetSum,0);
    }

    private boolean dfs(TreeNode node, int targetSum,int sum) {
        if(node!=null){
            if(node.left == null && node.right == null && sum+node.val == targetSum) return true;
            return dfs(node.left,targetSum,sum+node.val) || dfs(node.right,targetSum,sum+node.val);
        }
        return false;
    }

}
