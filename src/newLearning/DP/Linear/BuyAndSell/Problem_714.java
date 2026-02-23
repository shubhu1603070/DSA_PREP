package newLearning.DP.Linear.BuyAndSell;

import java.util.Arrays;

public class Problem_714 {

  public int maxProfit(int[] prices, int fee) {
    int[][] memo = new int[prices.length+1][prices.length+1];
    for (int[] d : memo) Arrays.fill(d,-1);
    return dfs(0,0,fee,prices,memo);
  }

  /*
    0 -> buy
    1 -> sell
    MLE
   */
  private int dfs(int index, int hold, int fee, int[] p,int[][] memo) {
    if(index >= p.length) {
      return 0;
    }
    if(memo[index][hold] != -1) return memo[index][hold];
    int ans = 0;
    if(hold == 0){
      /*
        skip
        buy
       */
      ans = Math.max(dfs(index+1,hold,fee,p,memo),-p[index] + dfs(index + 1,1,fee,p,memo));
    }else{
      /*
        skip
        sell
       */
      ans = Math.max(dfs(index+1,hold,fee,p,memo),p[index]+dfs(index+1,0,fee,p,memo) - fee);
    }
    return memo[index][hold] = ans;
  }


  private int bottomUP(int[] p,int fee){
    int n = p.length;
    int[][] dp = new int[n+1][2];
    for(int i = n-1;i>=0;i--){
      dp[i][0] = Math.max(dp[i+1][0],-p[i] + dp[i+1][1]);
      dp[i][1] = Math.max(dp[i+1][1],p[i] + dp[i+1][0] - fee);
    }
    return dp[0][0];
  }

  private int inPlace_714(int[] prices,int fee){
    int n = prices.length;
    int buy = 0; //[i+1][0]
    int sell = 0; //[i+1][1]
    for(int i = n-1;i >= 0;i--){
      buy = Math.max(buy,-prices[i]+sell);
      sell = Math.max(sell,prices[i]+buy - fee);
    }
    return buy;
  }


}
