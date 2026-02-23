package Trees.BinarySearchTree;

import Trees.TreeNode;

import java.util.*;

public class TwoSumIV_653 {

    Set<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        return dfs(root,k);
    }

    private boolean dfs(TreeNode root, int k) {
        if(root!=null){
            if(set.contains(k-root.val)) return true;
            set.add(root.val);
            return dfs(root.left,k) || dfs(root.right,k);
        }
        return false;
    }

}
