package newLearning.DP.knapsack;

import java.util.Arrays;

public class Problem_1049 {

    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        return subsetSum(stones,sum);
    }

    private int subsetSum(int[] stones, int sum) {
        boolean[][] dp = new boolean[stones.length+1][sum+1];
        for(int i=0;i<=stones.length;i++)
            dp[i][0] = true;
        for(int i = 1;i<=stones.length;i++){
            for (int j = 1;j<=sum;j++){
                if(stones[i-1]<=j) {
                    dp[i][j] = (dp[i - 1][j] || dp[i - 1][j - stones[i - 1]]);
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int s = sum/2;s>=0;s--){
            if(dp[stones.length][s]){
                min = Math.min(min,2*(s));
            }
        }
        return min;
    }

}
