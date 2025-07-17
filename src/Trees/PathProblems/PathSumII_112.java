package Trees.PathProblems;

import Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII_112 {


    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root,targetSum,0,new ArrayList<>());
        return res;
    }

    private void dfs(TreeNode node, int targetSum, int sum, ArrayList<Integer> iRes) {
        if(node != null){
            sum+=node.val;
            iRes.add(node.val);
            if(node.left == null && node.right == null && Math.abs(sum-targetSum) == 0){
                res.add(new ArrayList<>(iRes));
            }
            dfs(node.left,targetSum,sum,iRes);
            dfs(node.right,targetSum,sum,iRes);
            sum-=node.val;
            iRes.removeLast();
        }
    }

}
