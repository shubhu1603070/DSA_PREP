package backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSum_39 {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(0,candidates.length-1, candidates,target,0,new ArrayList<Integer>());
        return res;
    }

    private void dfs(int start,int end,int[] nums, int target,int sum, List<Integer> list) {
        if(start>end || sum > target) return;
        System.out.println("Start : "+start+ " End : "+end+" Sum : "+sum);
        if(sum == target){
            Collections.sort(list);
            if(!res.contains(list)) res.add(new ArrayList<>(list));
            return;
        }
        for (int index = start; index <= end; index++) {
            list.add(nums[index]);
            dfs(index,end,nums,target,sum+=nums[index],list);
            sum-=nums[index];
            list.remove(list.size()-1);
        }
    }

}
