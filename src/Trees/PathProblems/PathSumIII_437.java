package Trees.PathProblems;

import Trees.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII_437 {
    Map<Integer,Integer> map = new HashMap<>();

    public int pathSum(TreeNode root, int targetSum) {
        map.put(0,1);
        return dfs(root,0,targetSum);
    }

    private int dfs(TreeNode node,int runningSum, int targetSum) {
        if(node == null) return 0;
        runningSum+=node.val;
        int count = map.getOrDefault(runningSum-targetSum,0);
        map.put(runningSum,map.getOrDefault(runningSum,0)+1);
        count+=dfs(node.left,runningSum,targetSum)+dfs(node.right,runningSum,targetSum);
        map.put(runningSum, map.get(runningSum)-1);
        return count;
    }

}
