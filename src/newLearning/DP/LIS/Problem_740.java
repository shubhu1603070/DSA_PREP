package newLearning.DP.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_740 {

    int[][] memo;
    int[] f;
    int[] dp;
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int val : nums)
            max = Math.max(max,val);
        f =  new int[max+1];
        dp = new int[max+1];
        for(int val : nums) f[val]++;
        return solveDP(f,max+1,0);
    }

    //Didn't work
    private int solve(int[] nums,int index,int n,List<Integer> res) {
        if(index >= n) return 0;
        int val =  nums[index];
        int take = 0;
        if(res.isEmpty() || res.getLast()+1 != val) {
            res.add(val);
            take = solve(nums, index + 1, n, res) + val;
            res.removeLast();
        }
        int nottake = solve(nums,index+1,n,res);
        return Math.max(take,nottake);
    }

    //Didn't work
    int solve1(int[] nums,int index,int n,int preVal) {
        if(index >= n) return 0;
        int val = nums[index];
        int take = 0;
        int newIndex = index;
        int count = 0;
        while(newIndex < n && nums[newIndex] == val){
            newIndex++;
            count++;
        }
        if(preVal != -1 && memo[newIndex][preVal] != -1) return memo[newIndex][preVal];
        if(preVal+1 != val){
            take = solve1(nums,newIndex,n,val) + (val*count);
        }
        int nottake = solve1(nums,newIndex,n,preVal);
        int max = Math.max(take,nottake);
        return preVal != -1 ? memo[index][preVal] = max : max;
    }

    //finally worked
    private int solveDP(int[] f,int n,int index) {
        if(index >= n) return 0;
        if(dp[index] != -1) return dp[index];
        return dp[index] = Math.max((index * f[index])+ solveDP(f,n,index+2),solveDP(f,n,index+1));
    }
}
