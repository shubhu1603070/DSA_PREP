package newLearning.DP.knapsack;

import java.util.Arrays;

public class Problem_198 {

    private int result = 0;
    int[] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo,-1);
        return solve(nums, 0);
    }


    private int solve(int[] nums,int index){
        if(index == nums.length-1) return nums[index];
        if(index >= nums.length) return 0;
        if(memo[index] != -1) return memo[index];
        int consider = nums[index] + solve(nums,index+2);
        int notconsider = solve(nums,index+1);
        int max = Math.max(consider, notconsider);
        result += max;
        return memo[index] = max;
    }

}
