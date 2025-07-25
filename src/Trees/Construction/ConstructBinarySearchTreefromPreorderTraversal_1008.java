package Trees.Construction;

import Trees.TreeNode;

public class ConstructBinarySearchTreefromPreorderTraversal_1008 {

    int count = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return dfs(preorder,Integer.MAX_VALUE);
    }

    private TreeNode dfs(int[] preorder, int max) {
        if(count == preorder.length || preorder[count] > max) return null;
        TreeNode node = new TreeNode(preorder[count++]);
        System.out.println(node.val+" , "+max);
        node.left = dfs(preorder,node.val);
        node.right = dfs(preorder,max);
        return node;
    }

}
