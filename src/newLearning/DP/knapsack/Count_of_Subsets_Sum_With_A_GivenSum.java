package newLearning.DP.knapsack;

import java.util.Arrays;

public class Count_of_Subsets_Sum_With_A_GivenSum {

    int solve(int[] nums,int target,int index,int[][] dp){
        if(index == nums.length){
            if(target == 0) return 1;
            return 0;
        }
        if(dp[index][target] != -1) return dp[index][target];
        int take = 0;
        if(nums[index] <= target){
            take = solve(nums,target-nums[index],index+1,dp);
        }
        int donttake = solve(nums,target,index+1,dp);
        return dp[index][target] = take + donttake;
    }

    static public int perfectSum(int[] nums, int target) {
        // code here

        int n = nums.length;
        int[][] dp = new int[n+1][target+1];

        for(int i = 0;i<=n;i++){
            Arrays.fill(dp[i],0);
            dp[i][0] = 1;
        }

        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=target;j++){
                if(nums[i-1] <= j){
                    dp[i][j] = dp[i-1][j-nums[i-1]] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        int numberOfZeros = ((int) Arrays.stream(nums).filter(val -> val == 0).count());

        return numberOfZeros != 0 ? (2*numberOfZeros)*dp[n][target] : dp[n][target];
    }

}
