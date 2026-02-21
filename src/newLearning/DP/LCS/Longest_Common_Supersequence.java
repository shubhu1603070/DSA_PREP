package newLearning.DP.LCS;

import java.util.Arrays;

public class Longest_Common_Supersequence {

    int[][] dp;

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        int m = s1.length(), n = s2.length();
        Longest_Common_Supersequence lcs = new Longest_Common_Supersequence();
        int commonSubsequenceLen = lcs.checkLCSDP(s1, s2, m, n);
        System.out.println((m+n)-commonSubsequenceLen);
        //Print
        String res = lcs.longestCommonSubsequence(s1, s2);
        System.out.println("Common Supersequence : "+res);
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

    private String longestCommonSubsequence(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        checkLCSDP(s1, s2, m, n);
        StringBuilder stringBuilder = new StringBuilder();
        while(m > 0 && n > 0){
            if(s1.charAt(m-1) == s2.charAt(n-1)){
                stringBuilder.append(s1.charAt(m-1));
                m--;
                n--;
            }else if(dp[m-1][n] > dp[m][n-1]){
                stringBuilder.append(s1.charAt(m-1));
                m--;
            }else {
                stringBuilder.append(s2.charAt(n-1));
                n--;
            }
        }
        while(m > 0){
            stringBuilder.append(s1.charAt(m-1));
            m--;
        }
        while(n > 0){
            stringBuilder.append(s2.charAt(n-1));
            n--;
        }
        return stringBuilder.reverse().toString();
    }

}
