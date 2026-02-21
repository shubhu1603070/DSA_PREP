package newLearning.DP.LCS;

import java.util.Arrays;

public class Longest_Common_Substring {


    int[][] memo = new int[1001][1001];
    int[][] dp;
    private int maxLen = Integer.MIN_VALUE;
    private int endL = 0;

    public static void main(String[] args) {
        Longest_Common_Substring lcs = new Longest_Common_Substring();
        for(int[] a : lcs.memo){
            Arrays.fill(a,0);
        }
        System.out.println(lcs.checkLCSubstring("aefcktmop","afcltmop",8,7));
        System.out.println(lcs.checkLCSubstringDP("aefcktmop","afcltmop",9,8));
        System.out.println(lcs.printLongestSubstring("aefcktmop","afcltmop"));
    }

    private int checkLCSubstring(String a,String b,int m,int n){
        if(m < 0 || n < 0) return 0;
        else if(a.charAt(m) ==  b.charAt(n)){
            return memo[m][n] =  1 + checkLCSubstring(a,b,m-1,n-1);
        }
        return memo[m][n] = 0;
    }

    private int checkLCSubstringDP(String a,String b,int m,int n){
        dp = new int[m+1][n+1];
        for(int[] arr : dp) Arrays.fill(arr,0);
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return dp[m][n];
    }

        /*
        To print the longest subsequence
     */

    public String printLongestSubstring(String s1,String s2) {
        int m = s1.length(),n = s2.length();
        StringBuilder sb = new StringBuilder();
        printLCSubstringDP(s1,s2,m,n);
        return s1.substring(endL-maxLen,endL);
    }

    private void printLCSubstringDP(String a,String b,int m,int n){
        dp = new int[m+1][n+1];
        for(int[] arr : dp) Arrays.fill(arr,0);
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    if(dp[i][j] > maxLen){
                        maxLen = dp[i][j];
                        endL = i;
                    }
                }else{
                    dp[i][j] = 0;
                }
            }
        }
    }

}
