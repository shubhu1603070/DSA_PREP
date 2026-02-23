package newLearning.Graph.FloodFill;

import java.util.Arrays;

public class Problem_329 {

    public int longestIncreasingPath(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        for(int[] dpEle : dp){
            Arrays.fill(dpEle,-1);
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(dfs(matrix,dp,i,j,-2),res);
            }
        }

        return res;

    }

    private int dfs(int[][] matrix,int[][] dp,int row,int col, int ele) {

        if(row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length || matrix[row][col] <= ele) {
            return 0;
        }

        if(dp[row][col] != -1) return dp[row][col];
        int cur = matrix[row][col];
        int up = dfs(matrix,dp,row-1,col,cur);
        int down = dfs(matrix,dp,row+1,col,cur);
        int left = dfs(matrix,dp,row,col-1,cur);
        int right = dfs(matrix,dp,row,col+1,cur);

        return dp[row][col] = 1 + Math.max(Math.max(up,down), Math.max(left, right));

    }

}
