package Recursion.Externded_IO_OP;

import Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class UniqueBinarySearchTreesII_95 {

    public List<TreeNode> generateTrees(int n) {
        return dfs(1,n,new ArrayList<>());
    }

    private List<TreeNode> dfs(int start,int end,List<TreeNode> list){
        if(start > end) {
            list.add(null);
            return list;
        }
        for (int index = start; index <= end; index++) {
            List<TreeNode> left = dfs(start,index-1,new ArrayList<>());
            List<TreeNode> right = dfs(index+1,end,new ArrayList<>());
            for(TreeNode lnode : left){
                for (TreeNode rnode : right){
                    TreeNode node = new TreeNode(index);
                    node.left = lnode;
                    node.right = rnode;
                    list.add(node);
                }
            }
        }
        return list;
    }

}
