package Trees.BinarySearchTree;

import Trees.TreeNode;

public class TrimABST_669 {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        return dfs(root,low,high);
    }

    private TreeNode dfs(TreeNode node, int low, int high) {
        if(node == null) return null;
        if(node.left != null && node.left.val < low)
            return dfs(node.left,low,high);
        if(node.right != null && node.right.val > high)
            return dfs(node.right,low,high);
        node.left = dfs(node.left,low,high);
        node.right = dfs(node.right,low,high);
        return node;
    }

}
