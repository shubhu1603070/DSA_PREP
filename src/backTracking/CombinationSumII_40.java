package backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII_40 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(0,candidates.length-1, candidates,target,0,new ArrayList<Integer>());
        return res;
    }

    private void dfs(int start,int end,int[] nums, int target,int sum, List<Integer> list) {
        if(sum == target){
            if(!res.contains(list)) res.add(new ArrayList<>(list));
            return;
        }
        for (int index = start; index <= end; index++) {
            list.add(nums[index]);
            if(index>start && nums[index] == nums[index-1]) continue;
            dfs(index+1,end,nums,target,sum+=nums[index],list);
            sum-=nums[index];
            list.remove(list.size()-1);
        }
    }
}
