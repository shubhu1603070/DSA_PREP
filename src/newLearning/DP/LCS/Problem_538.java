package newLearning.DP.LCS;

public class Problem_538 {


  public int minDistance(String word1, String word2) {
    // int m = word1.length(),n = word2.length();
    // return (m +n) - 2 * solve(word1.toCharArray(),word2.toCharArray(),word1.length()-1,word2.length()-1);
    return solveDP(word1.toCharArray(),word2.toCharArray());
  }

  public int solveDP(char[] s1,char[] s2){
    int m = s1.length,n = s2.length;
    int[][] dp = new int[m+1][n+1];
    for(int i = 1;i<=m;i++){
      for(int j = 1;j<=n;j++){
        if(s1[i-1] == s2[j-1]){
          dp[i][j] = dp[i-1][j-1] + 1;
        }else{
          dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
        }
      }
    }
    return ((m - dp[m][n]) + (n - dp[m][n]));
  }

  public int solve(char[] s1,char[] s2,int m,int n){
    if(m < 0 || n < 0) return 0;
    if(s1[m] == s2[n]){
      return solve(s1,s2,m-1,n-1) + 1;
    }
    return Math.max(solve(s1,s2,m-1,n),solve(s1,s2,m,n-1));
  }

}
