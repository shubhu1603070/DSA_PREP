package newLearning.DP.LCS;

import java.util.Arrays;

public class Longest_Common_Subsequence {

    String result;
    int[][] memo;
    int[][] dp;


    public static void main(String[] args) {
        Longest_Common_Subsequence lcs=new Longest_Common_Subsequence();
        System.out.println(lcs.printLongestSubsequence("abdcefak","abtef"));
    }

    /*
        To get the length of the longest subsequence
     */
    public int longestSubsequence(String s1,String s2) {
        int m = s1.length(),n = s2.length();
        memo = new int[m+1][n+1];
        for(int[] a : memo) Arrays.fill(a,-1);
        return checkLCS(s1,s2, m,n);
    }


    private int checkLCS(String a,String b,int m,int n){
        if(m < 0 || n < 0) return 0;
        else if(a.charAt(m) ==  b.charAt(n)){
            System.out.print(a.charAt(m));
            return memo[m][n] =  1 + checkLCS(a,b,m-1,n-1);
        }
        return memo[m][n] = Math.max(checkLCS(a,b,m-1,n),checkLCS(a,b,m,n-1));
    }

    private int checkLCSDP(String a,String b,int m,int n){
        dp = new int[m+1][n+1];
        for(int[] arr : dp) Arrays.fill(arr,0);
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    /*
        To print the longest subsequence
     */

    public String printLongestSubsequence(String s1,String s2) {
        int m = s1.length(),n = s2.length();
        StringBuilder sb = new StringBuilder();
        printLCSDP(s1,s2,m,n);
        while(m > 0 && n > 0){
            if(s1.charAt(m-1) == s2.charAt(n-1)){
                sb.append(s1.charAt(m-1));
                m--;
                n--;
            } else{
                if(dp[m-1][n] > dp[m][n-1]){
                    m--;
                }else{
                    n--;
                }
            }
        }
        return sb.reverse().toString();
    }

    private void printLCSDP(String a,String b,int m,int n){
        dp = new int[m+1][n+1];
        for(int[] arr : dp) Arrays.fill(arr,0);
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
    }


  private int solve(String s1,String s2){
    int m = s1.length(),n = s2.length();
    if(m == 0 || n == 0) return 0;
    int[][] dp;
    if(m >=n) dp = new int[m+1][m+1];
    else dp = new int[n+1][n+1];
    for(int[] d : dp) Arrays.fill(d,-1);
    return dfs(s2,n,s1,m,0,0,dp);
  }

  private int dfs(String s1, int m, String s2, int n, int id1, int id2,int[][] dp) {
    if(id1 >= m || id2 >= n) return 0;
    if(dp[id1][id2] != -1) return dp[id1][id2];
    if(s1.charAt(id1) == s2.charAt(id2)){
      return 1 + dfs(s1,m,s2,n,id1+1,id2+1,dp);
    }
    return dp[id1][id2] = Math.max(dfs(s1,m,s2,n,id1+1,id2,dp),dfs(s1,m,s2,n,id1,id2+1,dp));
  }

  private int solveDP(String s1,String s2){
    int m = s1.length(),n = s2.length();
    if(m == 0 || n == 0) return 0;
    int[][] dp = new int[m+1][n+1];
    for(int[] d : dp) Arrays.fill(d,0);
    for(int i = 1; i <= m; i++){
      for(int j = 1; j <= n; j++){
        if(s1.charAt(i-1) == s2.charAt(j-1)){
          dp[i][j] = dp[i-1][j-1] + 1;
        }else{
          dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        }
      }
    }
    return m - dp[m][n];
  }

  public int minDistance(String s1, String s2) {
    int m = s1.length(),n = s2.length();
    if(m == 0 || n == 0) return 0;
    int[][] dp = new int[m+1][n+1];
    for(int[] d : dp) Arrays.fill(d,0);
    for(int i = 1; i <= m; i++){
      for(int j = 1; j <= n; j++){
        if(s1.charAt(i-1) == s2.charAt(j-1)){
          dp[i][j] = dp[i-1][j-1];
        }else{
          dp[i][j] = dp[i-1][j-1] + 1;
        }
      }
    }
    System.out.println(dp[m][n]);
    System.out.println(dfs(s1.toCharArray(),s2.toCharArray(),0,0));
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

  private int solveDP(char[] s1,char[] s2){
      int m = s1.length,n = s2.length;
      int[][] dp = new int[m+1][n+1];
      for(int[] d : dp) Arrays.fill(d,0);

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

}
