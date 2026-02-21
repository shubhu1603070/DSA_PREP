package newLearning.DP.knapsack;

import java.util.Arrays;

public class Minimum_Subset_Sum_Difference {

    public int minDifference(int[] arr) {
        int totalSum = Arrays.stream(arr).parallel().sum();

        int target = totalSum/2;

        int n = arr.length;
        int[][] dp = new int[n+1][target+1];
        dp[0][0] = 0;
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=target;j++){
                if(arr[i-1]<=j){
                    dp[i][j] = Math.max(arr[i-1]+dp[i-1][j-arr[i-1]] , dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        int s2 = dp[n][target];
        int s1 = totalSum - s2;
        return Math.abs(s2-s1);
    }

}
