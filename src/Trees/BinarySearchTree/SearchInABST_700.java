package Trees.BinarySearchTree;

import Trees.TreeNode;

public class SearchInABST_700 {

    public TreeNode searchBST(TreeNode root, int val) {
        return dfs(root,val);
    }

    private TreeNode dfs(TreeNode root,int val) {
        return root != null ? ((root.val == val) ? root : ((root.val > val) ? dfs(root.left,val) : dfs(root.right,val))) : null;
    }

}
