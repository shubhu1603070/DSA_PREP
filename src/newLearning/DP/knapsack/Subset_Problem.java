package newLearning.DP.knapsack;

public class Subset_Problem {

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n = arr.length;
        int[][] dp = new int[n+1][sum+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if(arr[i-1] <= j){
                    dp[i][j] = Math.max(arr[i-1]+dp[i-1][j-arr[i-1]] , dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum] == sum;
    }

}
