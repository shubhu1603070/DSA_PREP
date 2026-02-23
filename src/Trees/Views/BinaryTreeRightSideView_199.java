package Trees.Views;

import Trees.TreeNode;

import java.util.*;

public class BinaryTreeRightSideView_199 {
    Queue<TreeNode> queue = new LinkedList<>();
    List<Integer> list = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return Collections.emptyList();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = null;
            for (int count = 0; count < queue.size(); count++) {
                node = queue.peek();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            list.add(node.val);
        }
        return list;
    }


}
