package newLearning.Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem_78 {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new LinkedList<>();
        dfs(nums,0,new ArrayList<>());
        return result;
    }

    private void dfs(int[] nums, int idx, List<Integer> list) {
        if(idx >= nums.length){
            result.add(new LinkedList<>(list));
            return;
        }
        list.add(nums[idx]);
        dfs(nums,idx+1,list);
        list.removeLast();
        dfs(nums,idx+1,list);
    }

    private void loopVersion(int[] nums,int start,List<Integer> list,List<List<Integer>> result){
        result.add(new LinkedList<>(list));
        for(int i = start;i<nums.length;i++){
            list.add(nums[i]);
            loopVersion(nums,start+1,list,result);
            list.removeLast();
        }
    }

}
