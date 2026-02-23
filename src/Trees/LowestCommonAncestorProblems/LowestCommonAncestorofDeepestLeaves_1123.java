package Trees.LowestCommonAncestorProblems;

import Trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LowestCommonAncestorofDeepestLeaves_1123 {

    //865. Smallest Subtree with all the Deepest Nodes same as thus one

    class Pair{
        int depth;
        TreeNode node;

        public Pair(int depth, TreeNode node) {
            this.depth = depth;
            this.node = node;
        }
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Pair pair = dfs(root);
        return pair.node;
    }
    private Pair dfs(TreeNode node){
        if(node == null) return new Pair(0,null);
        Pair lPair = dfs(node.left);
        Pair rPair = dfs(node.right);
        if(lPair.depth == rPair.depth){
            return new Pair(lPair.depth+1,node);
        }else if(lPair.depth < rPair.depth){
            return new Pair(rPair.depth+1,rPair.node);
        }else{
            return new Pair(lPair.depth+1,lPair.node);
        }
    }
}
