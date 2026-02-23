package newLearning.DP.knapsack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_474 {



    int[][][] memo;
    public int findMaxForm(String[] strs, int m, int n) {
        List<Integer> pairs = new ArrayList<>();
        pairs = count(strs);
        memo = new int[strs.length+1][n+1][m+1];
        for(int i=0;i<strs.length;i++)
            for(int j=0;j<n+1;j++)
                Arrays.fill(memo[i][j],-1);
        return solve(strs,m,n,0,pairs);
    }

    private int solve(String[] strs, int m, int n,int index,List<Integer> list){
        if(index >= strs.length){
            return 0;
        }
        if(memo[index][m][n]!=-1){
            return memo[index][m][n];
        }
        Integer numberOfOnes = list.get(index);
        Integer numberOfZeroes = strs[index].length() - numberOfOnes;
        int consider = Integer.MIN_VALUE;
        if(m >= numberOfZeroes && n >= numberOfOnes){
            consider = solve(strs,m-numberOfZeroes,n-numberOfOnes,index+1,list) + 1;
        }
        int notConsider = solve(strs,m,n,index+1,list);
        return memo[index][m][n] = Math.max(consider,notConsider);
    }

    private List<Integer> count(String[] str){
        int count = 0;
        List<Integer> pairs = new ArrayList<>();
        for(String s: str){
            count = 0;
            for(Character ch : s.toCharArray()){
                if(ch == '1')
                    count++;
            }
            pairs.add(count);
        }
        return pairs;
    }


    private int solveDP(String[] strs, int m, int n,List<Integer> list){
        int[][] dp = new  int[m+1][n+1];
        int index = 0;
        for(int i=0;i<strs.length;i++){
            for(int j=0;j<n+1;j++){
                Integer numberOfOnes = list.get(index);
                Integer numberOfZeroes = strs[index].length() - numberOfOnes;
                dp[i][j] = Math.max(dp[i][j],dp[i-numberOfZeroes][j-numberOfZeroes] + 1);
            }
        }
        for(int[] d : dp){
            System.out.println(Arrays.toString(d));
        }
        return dp[m][n];
    }

}
