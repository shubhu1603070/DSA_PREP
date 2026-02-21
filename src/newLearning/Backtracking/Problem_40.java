package newLearning.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Problem_40 {

    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{1,1,2,3,4,5}, 8));
        System.out.println(combinationSum2(new int[]{14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12},27));
    }

    static public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combine(candidates,0,target,new ArrayList<>(),result);
        return result;
    }

    static private void combine(int[] nums,int start,int target,List<Integer> list,List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i = start;i<nums.length;i++){
            if(nums[i]>target) break; //This is called Active pruning
            if(i > start && nums[i]==nums[i-1]) continue; //To check if the values are unique
            list.add(nums[i]);
            combine(nums,i+1,target-nums[i],list,result);
            list.removeLast();
        }
    }

    static private void dfs(int idx, int[] candidates, int target, ArrayList<Integer> list, List<List<Integer>> result) {

        if(idx >= candidates.length || target < 0) return;
        if(target == 0){
            result.add(new ArrayList<>(list));
            return;
        }
        list.add(candidates[idx]);
        dfs(idx+1,candidates,target-candidates[idx],list,result);
        list.removeLast();
        dfs(idx+1,candidates,target,list,result);
    }

}
