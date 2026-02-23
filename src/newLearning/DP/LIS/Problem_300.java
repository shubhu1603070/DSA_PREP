package newLearning.DP.LIS;

import java.util.Arrays;

public class Problem_300 {

    public int lengthOfLISDFS(int[] nums) {
        return solve(nums,0,nums.length,Integer.MIN_VALUE);
    }

    private int solve(int[] nums, int index, int length, int minValue) {
        if(index >= length){
            return 0;
        }
        int take = 0,skip=0;
        if(nums[index] > minValue){
            take = solve(nums, index+1, length, nums[index])+1;
        }
        skip = solve(nums, index+1, length, minValue);
        return Math.max(take,skip);
    }

    int[][] memo;
    public int lengthOfLIS(int[] nums) {
        memo = new int[2501][2501];
        for(int[] a : memo) Arrays.fill(a, -1);
        return solveMemo(nums,0,nums.length,-1);

    }

    private int solveMemo(int[] nums,int index,int len,int pIndex){
        if(index >= len){
            return 0;
        }
        if(pIndex != -1 && memo[index][pIndex] != -1) return memo[index][pIndex];
        int take = 0,skip=0;
        if(nums[index] > pIndex){
            take = solveMemo(nums, index+1, len, index)+1;
        }
        skip = solveMemo(nums, index+1, len, pIndex);
        int max = Math.max(take, skip);
        return pIndex != -1 ? memo[index][pIndex] = max : max;
    }
}
