package newLearning.DP.knapsack;

import java.util.Arrays;

public class Problem_213 {

    private int result = 0;
    int[] memo;
    public int rob(int[] nums) {
        int n = nums.length;
        memo = new int[n];
        Arrays.fill(memo,-1);
        int a = solve(nums, 0,n-1);
        int b = solve(nums,1,n);
        return Math.max(a,b);
    }


    private int solve(int[] nums,int index,int n){
        if(index == n-1) return nums[index];
        if(index >= n) return 0;
        if(memo[index] != -1) return memo[index];
        int consider = nums[index] + solve(nums,index+2,n);
        int notconsider = solve(nums,index+1,n);
        int max = Math.max(consider, notconsider);
        result += max;
        return memo[index] = max;
    }

    private int solveDP(int[] nums,int index,int n){
        int p1 = 0,p2 = 0;
        int res = 0;
        for(int i=index;i<n;i++){
            int rob = nums[i] + p2;
            int skip = p1;
            int currentMax = Math.max(rob,skip);
            p2 = p1;
            p1 = currentMax;
        }
        return p1;
    }

}
