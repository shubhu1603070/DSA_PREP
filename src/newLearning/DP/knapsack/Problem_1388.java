package newLearning.DP.knapsack;

import java.util.Arrays;

public class Problem_1388 {


  public static void main(String[] args) {
    Problem_1388 p = new Problem_1388();
    System.out.println(p.maxSizeSlices(new int[]{1,2,3,4,5,6}));
  }

  public int maxSizeSlices(int[] slices) {
    int n = slices.length;
    int[][] dp = new int[501][3];
    for (int[] d : dp) Arrays.fill(d, -1);
    int a = dfs(0,n-2,slices,n/3,dp);
    for (int[] d : dp) Arrays.fill(d, -1);
    int b = dfs(1,n-1,slices,n/3,dp);
    return Math.max(a,b);
  }

  private int dfs(int index,int n,int[] slices,int slice,int[][] dp){
    if(slice <= 0) return 0;
    if(index > n) return Integer.MIN_VALUE;
    if(dp[index][slice] != -1) return dp[index][slice];
    return dp[index][slice] = Math.max(slices[index] + dfs(index+2,n,slices,slice-1,dp),dfs(index+1,n,slices,slice,dp));
  }

}
