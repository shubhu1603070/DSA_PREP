package newLearning.DP.knapsack;

public class Target_Sum {

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return solve(nums,target,0,0,n);
    }


    int solve(int[] nums,int target,int currentSum,int index,int n){
        if(index >= n){
            return target == currentSum ? 1 : 0;
        }
        int take = solve(nums,target,currentSum-nums[index],index+1,n);
        int donttake = solve(nums,target,currentSum+nums[index],index+1,n);
        return take + donttake;
    }

    private int solveDP(int[] nums,int target,int index,int n){
        if(n == index) return nums[index] == target ? 1 : 0;
        int[][] dp = new int[n+1][Math.abs(target)+1];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= target; j++){
                dp[i][j] = dp[i+1][Math.abs(target)+1] + dp[i+1][j-target];
            }
        }
        return dp[n][Math.abs(target)];
    }

}
