package newLearning.DP.Linear.BuyAndSell;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Problem_123 {

  // flag == true means i can buy
  // flag == false means i can sell
  private int dfs1_(int[] p,int index,int k,int n,boolean flag,int min){
    if(index >= n) return 0;
    if(k == 0) return 0;
    int f1 = 0,f2 = 0;
    if(!flag) f1 = dfs1_(p,index+1,k,n, true,Math.min(min,p[index]));
    else f2 = dfs1_(p,index+1,k-1,n, false,p[index]) - min;
    return Math.max(f1,f2);
  }

  /*
    here we have 3 states
    1. index
    2. buy / sell
    3. transactions

    at index i -> If I don't hold any stock we have two choices
      1. skip
      2. buy

    and at index i -> if I have already bought the stock I have two options
      1. skip
      2. sell at current index

    so when I sell at index -> i, I decrease the transaction also by 1 because i have utilized one transaction.

   */


//    private void dfs(int[] p,int[][][] dp){
//      int n = p.length;
//      for(int i = 0;i<n;i++){
//          dp[i][k][0] = Math.max(dp[i+1][k][0],-p[i]+dp[i+1][k][1]);
//          dp[i][k][1] = Math.max(dp[i+1][k][1],price[i]+dp[i+1][k-1][0]);
//        }
//    }

    private int dfs_(int i,int k,int hold,int[] p,int[][][] memo) {
      if(i >= p.length) return 0;
      if(k == 0) return 0;
      if(memo[i][k][hold] != -1) return memo[i][k][hold];
      int ans = 0;
      if(hold == 0){
        ans = Math.max(dfs_(i+1,k,0,p,memo),-p[i]+dfs_(i+1,k,1,p,memo));
      }else{
        ans = Math.max(dfs_(i+1,k,1,p,memo),p[i]+dfs_(i+1,k-1,0,p,memo));
      }
      return memo[i][k][hold] = ans;
    }

    private int convertDp(int[] p){
      int n = p.length;
      int[][][] dp = new int[n+1][3][2];
      for(int i = n-1;i >= 0;i--){
        for(int k = 1;k<=2;k++) {
          dp[i][k][0] = Math.max(dp[i + 1][k][0], -p[i] + dp[i + 1][k][1]);
          dp[i][k][1] = Math.max(dp[i + 1][k][1], p[i] + dp[i + 1][k - 1][0]);
        }
      }
      return dp[0][2][0];
    }


    private int inPlace(int[] p){
      int buySkip = 0;
      int buy = 0;
      int sellSkip = 0;
      int sell = 0;
      int n = p.length;
      for(int i = n-1;i >= 0;i--){
        buySkip = Math.max(buySkip,-p[i]);
        sellSkip = Math.max(sellSkip,buySkip + p[i]);
        buy = Math.max(buy , sellSkip - p[i]);
        sell = Math.max(sell,p[i]+buy);
      }
      return sell;
    }

}
