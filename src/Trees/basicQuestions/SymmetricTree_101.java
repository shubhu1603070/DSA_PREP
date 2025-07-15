package Trees.basicQuestions;

import Trees.TreeNode;

public class SymmetricTree_101 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return helper(root.left,root.right);
    }

    public boolean helper(TreeNode lNode,TreeNode rNode){
        if(lNode == null && rNode == null) return true;
        if(lNode !=null && rNode != null){
            if(lNode.val != rNode.val) return false;
            return helper(lNode.left,rNode.right) && helper(lNode.right,rNode.left);
        }
        return false;
    }

}
