package Trees.BinarySearchTree;

import Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AllElementsInTwoBinarySearchTrees_1305 {

    List<Integer> list = new ArrayList<>();

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return list;
        dfs(root1,root2);
        return list;
    }

    private void dfs(TreeNode oNode, TreeNode tNode) {
        if(oNode == null && tNode == null) return;
        dfs(oNode != null ? oNode.left : oNode, tNode != null ? tNode.left : tNode);
        if(oNode != null && tNode != null){
//            System.out.println("1 : "+oNode.val+" : "+tNode.val);
            if(oNode.val > tNode.val){
                list.add(tNode.val);
                list.add(oNode.val);
            }else{
                list.add(oNode.val);
                list.add(tNode.val);
            }
        }else if(oNode == null){
//            System.out.println("2 : "+tNode.val);
            list.add(tNode.val);
        }else{
//            System.out.println("3 : "+oNode.val);
            list.add(oNode.val);
        }
        dfs(oNode != null ? oNode.right : oNode ,tNode != null ? tNode.right : tNode);
    }


}
