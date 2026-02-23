package newLearning.DP.Linear.BuyAndSell;

public class Problem_121 {

  int profit = Integer.MIN_VALUE;
  public int maxProfit(int[] prices) {

    //if i don't buy it i can't sell it either so buying has to be true for selling
    //if i bought it on day i can sell it on i + 1 to n
    // dfs(0,prices);
    return dfs_(prices);
  }

  private int dfs_(int[] p){
    int index;
    int[] min = new int[p.length];
    min[0] = p[0];
    int[] max = new int[p.length];
    max[p.length-1] = p[p.length-1];
    for(index = 1;index < p.length;index++){
      min[index] = Math.min(min[index-1],p[index]);
    }
    for(index = p.length-2;index>=0;index--){
      max[index] = Math.max(max[index+1],p[index]);
    }
    int result = Integer.MIN_VALUE;
    for(index = 0;index < p.length;index++){
      result = Math.max(result,max[index]-min[index]);
    }
    return Math.max(result,0);
  }

  private int dfs1_(int[] p){
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for(int pr : p){
      min = Math.min(min,pr); //If it's minimum i'll take it and try to sell it later on
      max = Math.max(max,pr - min); //i'm selling it today will i be able to make more profit on this one
    }
    return Math.max(max,0);
  }

  private int dfs(int index,int[] p){
    if(index >= p.length) return 0;
    for(int i = index+1;i < p.length;i++){
      int sell = dfs(i,p) - p[index];
      if((p[i] - p[index]) > profit){
        this.profit = p[i] - p[index];
      }
    }
    return profit;
  }


}
