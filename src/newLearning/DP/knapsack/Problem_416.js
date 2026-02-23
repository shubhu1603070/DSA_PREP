package newLearning.DP.knapsack;

import java.util.Arrays;

public class Problem_416 {


    //Equal Sum Partition Sum
    public boolean canPartition(int[] nums) {
        int total = Arrays.stream(nums).parallel().sum();
        if(total%2!=0)
            return false;
        int target = total/2;
        return solveknapDP(nums,nums.length,target);
    }

    private  boolean solveknapDP(int[] nums,int n,int target){
        boolean[][] dp = new boolean[n+1][target+1];
        for(int i = 0;i<=n;i++){
            Arrays.fill(dp[i],false);
            for(int j = 0;j<=target;j++){
                dp[i][0] = true;
            }
        }

        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=target;j++){
                if(nums[i-1] <= j){
                    dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[n][target];
    }

}
