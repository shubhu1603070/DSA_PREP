package newLearning.DP.Linear.BuyAndSell;

public class Problem_309 {

  /*
  hold = 0 -> can buy
  hold = 1 -> can sell
 */
  private int dfs_309(int idx,int n,int[] p,int hold){
    if(idx >= p.length) return 0;
    int ans = Integer.MIN_VALUE;
    if(hold == 0){
        /*
          skip
          buy
         */
      ans = Math.max(dfs_309(idx+1,n,p,hold),-p[idx] + dfs_309(idx+1,n,p,1));
    }else{
      ans = Math.max(dfs_309(idx+1,n,p,hold),p[idx] + dfs_309(idx + 2,n,p,0));
    }
    return ans;
  }

  private int bottomUp_309(int[] p){
    //states -> index,buy/sell
    // ith state -> dp[index][buy/sell]
    int n = p.length;
    int[][] dp = new int[n+2][n+2];
    for(int i = n-1;i >= 0;i--){
      dp[i][0] = Math.max(dp[i+1][0],-p[i]+dp[i+1][1]);
      dp[i][1] = Math.max(dp[i+1][1],p[i]+dp[i+2][0]);
    }
    return 0;
  }

  private int inPlace_309(int[] prices){
    int n = prices.length;
    int buy = 0; //[i+1][0]
    int sell = 0; //[i+1][1]
    int nextBuy = 0; //[i+2][0]
    for(int i = n-1;i >= 0;i--){
      int cBuy = Math.max(buy,-prices[i]+sell);
      int cSell = Math.max(sell,prices[i]+nextBuy);
      nextBuy = buy;
      buy = cBuy;
      sell = cSell;
    }
    return buy;
  }



}
