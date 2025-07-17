package Trees.BinarySearchTree;

import Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AllElementsInTwoBinarySearchTrees_1305 {

    List<Integer> list = new ArrayList<>();

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        return bfs(root1,root2);
    }

    //TIME O(M + N)
    //SPACE O(M + N)
    private List<Integer> bfs(TreeNode oNode, TreeNode tNode) {
        Stack<TreeNode> lStack = new Stack<>(); // O(H1)
        Stack<TreeNode> rStack = new Stack<>(); // O(H2)
        List<Integer> result = new ArrayList<>(); // O(M + N)

        while(oNode != null || tNode!=null || !lStack.isEmpty() || !rStack.isEmpty()){
            while(oNode!=null) {
                lStack.push(oNode);
                oNode = oNode.left;
            }

            while(tNode!=null) {
                rStack.push(tNode);
                tNode = tNode.left;
            }

            if(rStack.isEmpty() || (!lStack.isEmpty() && lStack.peek().val <= rStack.peek().val)){
                TreeNode peek = lStack.pop();
                result.add(peek.val);
                oNode = peek.right;
            }else{
                TreeNode peek = rStack.pop();
                result.add(peek.val);
                tNode = peek.right;
            }

        }
        return result;
    }


}
