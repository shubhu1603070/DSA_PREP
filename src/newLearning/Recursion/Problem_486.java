package newLearning.Recursion;

import java.util.Arrays;

public class Problem_486 {

    int[][] memo;
    public boolean predictTheWinner(int[] nums) {
        int total = Arrays.stream(nums).sum();
        memo = new int[nums.length+1][nums.length+1];
        for(int[] a : memo){
            Arrays.fill(a,-1);
        }
        int result = memo(nums,0,nums.length-1);
        return result > total - result;
    }

    private int solve(int[] nums,int start,int end){
        if(start > end) return 0;
        int chooseStart = nums[start] + Math.min(
                solve(nums,start+2,end),
                solve(nums,start+1,end-1)
        );
        int chooseEnd = nums[end] + Math.min(
                solve(nums,start+1,end-1),
                solve(nums,start,end-2)
        );
        return Math.max(chooseStart,chooseEnd);

    }

    private int memo(int[] nums,int start,int end){
        if(start > end) return 0;
        if(start == end) return nums[start];
        if(memo[start][end] != -1) return memo[start][end];
        int chooseStart = nums[start] + Math.min(
                solve(nums,start+2,end),
                solve(nums,start+1,end-1)
        );
        int chooseEnd = nums[end] + Math.min(
                solve(nums,start+1,end-1),
                solve(nums,start,end-2)
        );
        return memo[start][end] = Math.max(chooseStart,chooseEnd);
    }


}
