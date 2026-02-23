package newLearning.DP.MCM;

import java.util.Arrays;

public class Problem_312 {

    int[][] memo;

    public int maxCoins(int[] inums) {
        int n = inums.length;
        memo = new int[n+1][n+1];
        for(int[] a : memo) Arrays.fill(a,-1);
        int[] nums = new int[n+2];
        Arrays.fill(nums,1);
        for(int i=1;i<=n;i++){
            nums[i] = inums[i-1];
        }
        System.out.println(Arrays.toString(nums));
        return solve(nums,0,n+1);
    }

    private int solve(int[] nums,int i,int j){
        if(i+1 == j) return 0;
        if(memo[i][j] != -1) return memo[i][j];
        int res = 0;
        for(int k=i+1;k<j;k++){
            res = Math.max(res,solve(nums,i,k) + solve(nums,k,j) + (nums[i] * nums[k] * nums[j]));
        }
        return memo[i][j] = res;
    }

}
