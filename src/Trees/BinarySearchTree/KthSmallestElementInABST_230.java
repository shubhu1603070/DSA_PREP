package Trees.BinarySearchTree;

import Trees.TreeNode;

public class KthSmallestElementInABST_230 {

    int[] ans = {0};
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        dfs(root,k,ans);
        return ans[0];
    }

    private void dfs(TreeNode node, int k,int[] ans) {
        if(node == null) return;
        dfs(node.left,k,ans);
        k--;
        if(k == 0) { ans[0] = node.val; return;}
        dfs(node.right,k,ans);
    }

}
