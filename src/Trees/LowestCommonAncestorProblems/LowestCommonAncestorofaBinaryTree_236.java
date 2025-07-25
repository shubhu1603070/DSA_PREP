package Trees.LowestCommonAncestorProblems;

import Trees.TreeNode;

public class LowestCommonAncestorofaBinaryTree_236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
     return dfs(root,p,q);
    }

    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || p == root || q == root) return root;
        TreeNode lc = lowestCommonAncestor(root.left,p,q);
        TreeNode rc = lowestCommonAncestor(root.right,p,q);
        return lc == null ? rc : rc == null ? lc : root;
    }

}
