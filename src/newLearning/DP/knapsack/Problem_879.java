package newLearning.DP.knapsack;

import java.util.Arrays;

public class Problem_879 {


  public static void main(String[] args) {
    Problem_879 obj = new Problem_879();
    System.out.println(obj.profitableSchemes(10,5,new int[]{2,3,5},new int[]{6,7,8}));
    System.out.println(obj.profitableSchemes(5,3,new int[]{2,2},new int[]{2,3}));
    System.out.println(obj.profitableSchemes(64,0,new int[]{80, 40},new int[]{88,88}));
    System.out.println(obj.profitableSchemes(95,53,new int[]{82,7,18,34,1,3,83,56,50,34,39,38,76,92,71,2,6,74,1,82,22,73,88,98,6,71,6,26,100,75,57,88,43,16,22,89,7,9,78,97,22,87,34,81,74,56,49,94,87,71,59,6,20,66,64,37,2,42,30,87,73,16,39,87,28,9,95,78,43,59,87,78,2,93,7,22,21,59,68,67,65,63,78,20,82,35,86},new int[]{45,57,38,64,52,92,31,57,31,52,3,12,93,8,11,60,55,92,42,27,40,10,77,53,8,34,87,39,8,35,28,70,32,97,88,54,82,54,54,10,78,23,82,52,10,49,8,36,9,52,81,26,5,2,30,39,89,62,39,100,67,33,86,22,49,15,94,59,47,41,45,17,99,87,77,48,22,77,82,85,97,66,3,38,49,60,66}));
  }

  private int cnt;
  public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
    int[][][] dp = new int[101][101][101];
    for(int[][] d : dp){
      for(int[] a : d) Arrays.fill(a, -1);
    }
    return dfs(n,0,minProfit,0,group,profit,dp);
  }

  private int dfs(int numberOfPeopleLeft,int index,int minProfit,int profit,int[] grp,int[] pro,int[][][] dp){
    if(index >= grp.length){
      return (profit >= minProfit) ? 1 : 0;
    }
    profit = Math.min(profit,minProfit);
    if(dp[numberOfPeopleLeft][index][profit] != -1){
      return dp[numberOfPeopleLeft][index][profit];
    }
    int ways = 0;
    if(numberOfPeopleLeft >= grp[index]){
      ways += dfs(numberOfPeopleLeft-grp[index],index+1,minProfit,profit+pro[index],grp,pro,dp);
    }
    ways += dfs(numberOfPeopleLeft,index+1,minProfit,profit,grp,pro,dp);
    return dp[numberOfPeopleLeft][index][profit] = ways % ((int) 1e9+7);
  }

  private int bottomUP(int[] grp,int[] pro,int min,int n){
    int[][][] dp = new int[101][101][101];
    for(int[][] d : dp){
      for(int[] a : d) Arrays.fill(a, -1);
    }
    int mod = (int) 1e9+7;
    for(int index = pro.length-1; index >= 0; index--){
      for(int people = 0; people < n; people++){
        for(int profit = 0; profit <= min; profit++){
          int ways = dp[people][index+1][profit];
          if(people >= grp[index]){
            int newProfit = Math.min(min,profit + pro[index]);
            ways = (ways + dp[people - grp[index]][index+1][newProfit]) % mod;
          }
          dp[people][index][profit] = ways;
        }
      }
    }
    return dp[n][0][0];
  }


}
