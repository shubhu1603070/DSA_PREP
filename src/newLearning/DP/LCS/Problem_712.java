package newLearning.DP.LCS;

import newLearning.DP.Linear.Problem_689;

import java.util.Arrays;
import java.util.Set;

public class Problem_712 {


  /*
    this question is about finding the LCS but not only LCS
    It's not important that we find the longest common subsequence
    Even if the by deleting length 2 values gives me the highest ascii value than the length 3 then i'll consider
    length 2 string reason I have to return lowest ascii value
   */

  public static void main(String[] args) {
    Problem_712 p = new Problem_712();
    System.out.println(p.minimumDeleteSum("sea","eat"));
    System.out.println(p.minimumDeleteSum("delete","leet"));
  }

  public int minimumDeleteSum(String s1, String s2) {
    return checkLCS(s1,s2,s1.length(),s2.length());
  }

  private int checkLCS(String a,String b,int m,int n){
    int[][] dp = new int[m+1][n+1];
    int sum = 0;

    int sum1 = 0,sum2 = 0;

    for(char ch : a.toCharArray()){
      sum1 += ch;
    }

    for(char ch : b.toCharArray()){
      sum2 += ch;
    }

    for(int i = 1; i <= m; i++){
      for(int j = 1; j <= n; j++){
        if(a.charAt(i-1) == b.charAt(j-1)){
          dp[i][j] = dp[i-1][j-1] + a.charAt(i-1);
        }else{
          dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        }
      }
    }

    while(m > 0 && n > 0){
      if(a.charAt(m-1) == b.charAt(n-1)){
        sum += a.charAt(m-1);
        m--;
        n--;
      }else {
        if (dp[m - 1][n] > dp[m][n - 1]) {
          m--;
        } else {
          n--;
        }
      }
    }

    System.out.println("sum1 : "+sum1+", sum2 : "+sum2);
    System.out.println(Arrays.deepToString(dp));

    return (sum1 - sum) + (sum2 - sum);
  }


}
