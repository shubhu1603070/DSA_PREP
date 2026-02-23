package Trees.PathProblems;

import Trees.TreeNode;
import Trees.Utils;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PseudoPalindromicPathsinaBinaryTree_1457 {

    Set<String> set = new HashSet<>();
    int result = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        dfs(root,new int[10]);
        return result;
    }

    private void dfs(TreeNode node,int[] freq) {
        if(node == null) return;
        freq[node.val]++;
        if(node.left == null && node.right == null){
            if(countFreq(freq)){
                result++;
            }
        }
        dfs(node.left,freq);
        dfs(node.right,freq);
        freq[node.val]--;
    }

    private boolean countFreq(int[] freq) {
        int odd = 0;
        for(int val : freq){
            if(val%2 != 0) odd++;
            if(odd > 1) return false;
        }
        return true;
    }

    public void rootToLeaf(TreeNode node,int count){
        if(node == null) return;
        count = count*10+node.val;
        rootToLeaf(node.left,count);
        rootToLeaf(node.right,count);
        count = count/10;
    }

}
