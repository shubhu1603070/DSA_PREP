package Trees.BinarySearchTree;

import Trees.TreeNode;

public class DeleteNode_450 {

    public TreeNode deleteNode(TreeNode node, int key) {
        if(node == null) return node;
        TreeNode dummy = node;
        if(node.val == key){
            return helper(node);
        }

        while(node!=null){
            if(node.val > key){
                if(node.left != null && node.left.val == key){
                    node.left = helper(node.left);
                }else{
                    node = node.left;
                }
            }else{
                if(node.right != null && node.right.val == key){
                    node.right = helper(node.right);
                }else{
                    node = node.right;
                }
            }
        }
        return dummy;
    }


    private TreeNode helper(TreeNode node){
        if(node.left == null) return node.right;
        if(node.right == null) return node.left;
        TreeNode rightNode = node.right;
        TreeNode leftSubTreeRightestNode = findRightestRightNode(node.left);
        leftSubTreeRightestNode.right = rightNode;
        return node.left;
    }

    private TreeNode findRightestRightNode(TreeNode node) {
        while(node.right!=null){
            node = node.right;
        }
        return node;
    }


}
