package newLearning.DP.LCS;

import java.util.Arrays;

public class Problem_72 {

  public int minDistance(String s1, String s2) {
    // return dfs(s1.toCharArray(),s2.toCharArray(),0,0);
    if(s1.isEmpty()) return s2.length();
    if(s2.isEmpty()) return s1.length();
    return solveDP(s1.toCharArray(),s2.toCharArray());
  }

  private int solveDP(char[] s1,char[] s2){
    int m = s1.length,n = s2.length;
    int[][] dp = new int[m+1][n+1];
    for(int[] d : dp) Arrays.fill(d,0);
    for(int i = 0;i<=s1.length;i++) dp[i][0] = i;
    for(int j = 0;j<=s2.length;j++) dp[0][j] = j;
    for(int i = 1; i <= m; i++){
      for(int j = 1; j <= n; j++){
        if(s1[i-1] == s2[j-1]){
          dp[i][j] = dp[i-1][j-1];
        }else{
          dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
        }
      }
    }
    return dp[m][n];
  }

  private int dfs(char[] s1,char[] s2,int id1,int id2){
    if(id1 >= s1.length) return s2.length - id2;
    if(id2 >= s2.length) return s1.length - id1;
    if(s1[id1] == s2[id2]){
      return dfs(s1,s2,id1+1,id2+1);
    }
    int insert = dfs(s1,s2,id1,id2+1) + 1;
    int delete = dfs(s1,s2,id1+1,id2) + 1;
    int replace = dfs(s1,s2,id1+1,id2+1) + 1;
    return Math.min(insert, Math.min(delete, replace));
  }

}
