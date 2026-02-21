package newLearning.DP.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_368 {

    List<Integer> res;
    int[][] memo;

    public static void main(String[] args) {
        Problem_368 p = new Problem_368();
        p.largestDivisibleSubset(new int[]{1,2,3});
        p.largestDivisibleSubset(new int[]{1,2,4,8});
        p.largestDivisibleSubset(new int[]{2,5,8,6,3,4,12});
        p.largestDivisibleSubset(new int[]{3,4,16,8});
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length;
        memo = new int[len][len];
        for (int[] a : memo) Arrays.fill(a, -1);
        res =  new ArrayList<>();
        Arrays.sort(nums);
        solve(nums,0,len,new ArrayList<>());
        System.out.println(res);
        return res;
    }

    private void solve(int[] nums, int currentIndex, int len,List<Integer> currentList) {
        int take = 0,skip = 0;
        if(currentIndex >= len) return;
        if(currentList.isEmpty() || (nums[currentIndex] % currentList.getLast() == 0)){
            if((!res.isEmpty() && !currentList.isEmpty() && currentList.getLast() > res.getLast()) || res.isEmpty()) {
                currentList.add(nums[currentIndex]);
                System.out.println(nums[currentIndex]);
                System.out.println(currentList + " : " + res);
                solve(nums, currentIndex + 1, len, currentList);
                if (currentList.size() > res.size()) {
                    res = new ArrayList<>(currentList);
                }
                currentList.removeLast();
            }
        }
        solve(nums,currentIndex+1,len,currentList);
    }

    private void solve1(int[] nums,int index,int n,int pIndex,List<Integer> currentList){
        if(index >= n) {
            if (currentList.size() > res.size()) {
                res.clear();
                res.addAll(currentList);
            }
            return;
        }
        if(nums[index] % pIndex == 0 || pIndex % nums[index] == 0){
            currentList.add(nums[index]);
            solve1(nums,index+1,n,nums[index],currentList);
            currentList.removeLast();
        }
        solve1(nums,index+1,n,pIndex,currentList);
    }

    private List<Integer> LIS(int[] nums,int n){
        int[] dp = new int[n+1];
        int[] prev = new int[n+1];
        int maxIndex = 0;
        List<Integer> res = new ArrayList<>();
        for(int i = 1;i<n;i++){
            for(int j = i-1;j>=0;j--){
                if(nums[i] % nums[j] == 0){
                    if(dp[i] < dp[j]+1){
                        dp[i] = dp[j]+1;
                        prev[i] = j;
                    }
                }
            }
        }

        for(int i = 1;i<n;i++){
            maxIndex = Math.max(dp[maxIndex],dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(prev));
        System.out.println(maxIndex);

        return res;
    }

}
