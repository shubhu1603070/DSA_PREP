package Trees.Validate;

import Trees.TreeNode;

public class ValidateBinarySearchTree_98 {

    public boolean isValidBST(TreeNode root) {
        return dfs(root);
    }

    private boolean dfs(TreeNode node) {
        if(node == null) return true;
        if(node.left!=null && node.left.val > node.val){
            return false;
        }
        if(node.right!=null && node.right.val < node.val){
            return false;
        }
        return dfs(node.left) && dfs(node.right);
    }

}
