package Trees.BinarySearchTree;

import Trees.TreeNode;

public class MinAbsDifferenceInBST_530 {

    private TreeNode prev = null;
    private int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    private void dfs(TreeNode root) {
        if(root == null) return;
        dfs(root.left);
        if(prev != null){
            System.out.println("Prev: "+prev.val+" Root: "+root.val);
            min = Math.min(min,Math.abs(prev.val - root.val));
        }
        prev = root;
        dfs(root.right);
    }

}
