package newLearning.DP.knapsack.unbounded;

import java.util.Arrays;

public class Problem_322 {

    int[][] memo;
    public int coinChange(int[] coins, int amount) {
        memo = new int[coins.length+1][amount+1];
        for(int a[] : memo) Arrays.fill(a,-1);
        return solve(coins,0,coins.length,amount,0);
    }

    //TLE
    private int solve(int[] coins,int index,int n,int sum,int num){
        if(index > n || sum < 0){
            return 0;
        }
        if(index == n || sum == 0){
            return sum == 0 ? num : 0;
        }
        int exclude = solve(coins,index+1,n,sum,num);
        int include = Integer.MAX_VALUE;
        if(sum >= coins[index]) include = solve(coins,index,n,sum-coins[index],num+1);
        return Math.min(exclude,include);
    }

    //TLE
    private int solveMemo(int[] coins,int index,int n,int sum,int num){
        if(index > n || sum < 0){
            return 0;
        }
        if(index == n || sum == 0){
            return sum == 0 ? num : 0;
        }
        if(memo[index][sum] != -1) return memo[index][sum];
        int exclude = solve(coins,index+1,n,sum,num);
        int include = Integer.MAX_VALUE;
        if(sum >= coins[index]) include = solve(coins,index,n,sum-coins[index],num+1);
        return memo[index][sum] = Math.min(exclude,include);
    }

    //DP
    private int solveDP(int[] coins,int n,int amount){
        int[][] dp = new int[n+1][amount+1];
        for(int i =0;i<=amount;i++){
            dp[0][i] = Integer.MAX_VALUE;
        }

        for(int i = 0;i < coins.length;i++){
            dp[i][0] = Integer.MAX_VALUE;
        }
        for(int i = 1;i <= n;i++){
            for(int j = 1;j <= amount;j++){
                if(j >= coins[i-1]){
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][amount];
    }

    //convert this into 1D dp
    // if we see dp[i][j] is nothing but the number of coins required to reach amount j so
    private int solveDP1(int[] coins,int n,int amount){
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for(int i = 1;i<=amount;i++){
            for(int coin : coins){
                if(i >= coin){
                    dp[i] = Math.min(dp[i],dp[i-coin]+1);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[amount];
    }

}
