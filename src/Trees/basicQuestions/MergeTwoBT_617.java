package Trees.basicQuestions;

import Trees.TreeNode;

public class MergeTwoBT_617 {

    public TreeNode mergeTrees(TreeNode lNode, TreeNode rNode) {
        if(lNode == null && rNode == null) return null;
        if(lNode == null) return rNode;
        if(rNode == null) return lNode;
        TreeNode node = new TreeNode(lNode.val+ rNode.val);
        node.left = mergeTrees(lNode.left,rNode.left);
        node.right = mergeTrees(lNode.right,rNode.right);
        return node;
    }
}
