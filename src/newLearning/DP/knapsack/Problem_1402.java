package newLearning.DP.knapsack;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Problem_1402 {


  public int maxSatisfaction(int[] nums) {
    int[][] memo = new int[nums.length+1][nums.length+1];
    Arrays.sort(nums);
    for (int[] d : memo) {
      Arrays.fill(d,-1);
    }
    return solve(nums, 0, 1, memo);
  }

  private int solve(int[] nums,int index,int idx,int[][] memo) {
    if(index >= nums.length) return 0;
    if(memo[index][idx] != -1) return memo[index][idx];
    return memo[index][idx] = Math.max((nums[index] * idx) + solve(nums,index+1,idx+1,memo),solve(nums,index+1,idx,memo));
  }

  private int solveDP(int[] nums){
    int n = nums.length;
    int[][] dp = new int[n+1][n+1];
    for(int i = 0;i<=n;i++){
      Arrays.fill(dp[i],-100_000_000);
      dp[i][0] = 0;
    }

    for(int dish = 1;dish<=n;dish++){
      for(int time = 1;time<=dish;time++){
        int cook = dp[dish-1][time-1] + (nums[dish-1] * time);
        int skip = dp[dish-1][time];
        dp[dish][time] = Math.max(cook,skip);
      }
    }
    return Arrays.stream(dp[n]).max().getAsInt();
  }

  public int findMaxForm(String[] strs, int m, int n) {
    int len = strs.length;
    int[] size = new int[len];
    count(strs,size);
    return dfs(strs,m,n,size,0);
  }

  private void count(String[] strs, int[] size){
    int j = 0;
    for(String str : strs){
      int count = 0;
      for(char c : str.toCharArray()){
        if(c == '0') count++;
      }
      size[j++] = count;
    }
  }

  private int dfs(String[] strs,int m,int n,int[] size,int index) {
    if (index >= strs.length) {
      return 0;
    }
    int totalLen = strs[index].length();
    int countOfOne = totalLen - size[index];
    int countOfZeros = size[index];
    int take = 0, notTake = 0;
    if (countOfZeros <= m && countOfOne <= n) {
      take = 1 + dfs(strs, m-countOfZeros, n-countOfOne, size, index + 1);
    }
    notTake = dfs(strs, m, n, size, index + 1);
    return Math.max(take, notTake);
  }

  private int solveDP(String[] strs,int m,int n){
    int len = strs.length;
    int[][][] dp = new int[len+1][m+1][n+1];
    for(int[][] d : dp)
      for(int[] a : d)
        Arrays.fill(a,0);

    for(int  i = 1;i<=len;i++){
      int countOfZeros = 0;
      int countOfOne = 0;
      for(char c : strs[i-1].toCharArray()){
        if(c == '0') countOfZeros++;
        else countOfOne++;
      }
      for(int j = 0;j<=m;j++){ // zero
        for(int k = 0;k<=n;k++){ // one
          int notTake = dp[i-1][j][k];
          int take = 0;
          if(countOfZeros <= j && countOfOne <= k){
            take = dp[i-1][j - countOfZeros][k - countOfOne] + 1;
          }
          dp[i][j][k] = Math.max(take,notTake);
        }
      }
    }
    return dp[len][m][n];
  }


  private int solveDP_(String[] strs,int m,int n){

    if(strs.length == 0) return 0;

    int[][] dp = new  int[m+1][n+1];

    for(String str : strs){
      int countOfZeros = 0;
      int countOfOne = 0;
      for(char c : str.toCharArray()){
        if(c == '0') countOfZeros++;
        else countOfOne++;
      }

      for(int i = m;i>=0;i--){
        for(int j = n;j>=0;j--){
          int notTake = dp[i][j];
          int take = 0;
          if(countOfZeros <= i && countOfOne <= j){
            take = dp[i - countOfZeros][j - countOfOne] + 1;
          }
          dp[i][j] = Math.max(take,notTake);
        }
      }
    }
    return dp[m][n];
  }

}
