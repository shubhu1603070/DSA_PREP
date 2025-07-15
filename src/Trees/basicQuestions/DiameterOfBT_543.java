package Trees.basicQuestions;

import Trees.TreeNode;

public class DiameterOfBT_543 {

    int result = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        helper(root.left);
        return result;
    }

    private int helper(TreeNode node){
        if(node == null) return 0;
        if(node.left == null && node.right == null) return 1;
        int left = helper(node.left);
        int right = helper(node.right);
        result = Math.max(result,left+right);
        return 1 + Math.max(left,right);
    }

}
