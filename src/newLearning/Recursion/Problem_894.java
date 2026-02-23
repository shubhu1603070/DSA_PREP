package newLearning.Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem_894 {

    Map<Integer,List<TreeNode>> map = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(new TreeNode(0));
        map.put(1,treeNodes);
        return solve(n);
    }

    private List<TreeNode> solve(int n){
        List<TreeNode> result = new ArrayList<>();
        if(map.containsKey(n)) return map.get(n);
        n-=1;
        for(int left = 1;left<n;left+=2){
            List<TreeNode> leftNode = solve(left);
            List<TreeNode> rightNode = solve(n-left);
            for(TreeNode l : leftNode){
                for(TreeNode r : rightNode){
                    TreeNode node = new TreeNode(0,l,r);
                    result.add(node);
                }
            }
        }
        map.put(n,result);
        return result;
    }
}
