package Trees.PathProblems;

import Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths_257 {

    List<String> list = new ArrayList<>();

    // SPACE : O(N) / TIME O(N):
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root,"");
        return list;
    }

    private void dfs(TreeNode node, String str) {
        if(node == null) {
            return;
        }
        str = str.concat(node.val+"->");
        //System.out.println("node : "+node.val+" str: "+str);
        dfs(node.left,str);
        dfs(node.right,str);
        if(node.left == null && node.right == null){list.add(str.substring(0,str.length()-2));}
    }

}
