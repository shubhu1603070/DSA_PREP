package newLearning.DP.Linear;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_689 {

  public static void main(String[] args) {
    Problem_689 p = new Problem_689();
    System.out.println(Arrays.toString(p.maxSumOfThreeSubarrays(new int[]{1,2,1,2,6,7,5,1},2)));
  }

  public int[] maxSumOfThreeSubarrays_1(int[] nums, int k) {
    int n = nums.length;
    int[] windows = new int[n - k + 1];
    int sum = 0;
    for(int i = 0; i < n; i++){
      sum += nums[i];
      if(i >= k) sum -= nums[i - k];
      if(i >= k - 1) windows[i - k + 1] = sum;
    }

    int[] left = new int[n - k +1];
    int[] right = new int[n - k + 1];

    n = n-1;
    left[0] = 0;
    for(int i = 1; i < n-1; i++){
      left[i] = (windows[i] > windows[left[i-1]]) ? i : left[i-1];
    }


    right[n-1] = n-1;
    for (int i = n-2; i > 0; i--) {
      right[i] = (windows[i] > windows[right[i+1]]) ?  i : right[i+1];
    }

    int[] ans = new int[3];
    int max = 0;
//    n++;
    for(int mid = k;mid < (n - k);mid++){
      int l = left[mid-k];
      int r = right[mid+k];
      int total = windows[l] + windows[r] + windows[mid];
      if(total > max){
        max = total;
        ans[0] = l;
        ans[1] = mid;
        ans[2] = r;
      }
    }
    System.out.println(Arrays.toString(ans));
    return ans;
  }

  int[][] dp = new int[20001][3];
  private int[] maxSumOfThreeSubarrays(int[] nums,int k) {
    int n = nums.length;
    int m = n - k + 1;
    int[] windows = new int[n - k + 1];
    int[] ans = new int[3];
    int sum = 0;
    int i = 0;
    int j = 0;
    while(j < n){
      sum += nums[j];
      if(j - i + 1 == k){
        windows[i] = sum;
        sum-=nums[i++];
      }
      j++;
    }

    for(int[] a : dp) Arrays.fill(a,-1);

    solve(windows,3,0,k,ans);

    System.out.println(Arrays.toString(windows));
    return ans;
  }

  int i = 0;
  private void solve(int[] windows, int count, int index, int k, int[] ans) {
    if(count == 0 || index >= windows.length) return;
    int take_index = windows[index] + helper(windows,count - 1,index + k,k);
    int not_take_index = helper(windows,count,index+1,k);
    if(take_index >= not_take_index){
      ans[i++] = index;
      solve(windows,count-1,index+k,k,ans);
    }else{
      solve(windows,count,index+1,k,ans);
    }
  }

  private int helper(int[] windows, int count, int index, int k) {
      if(count == 0) return count;
      if(index >= windows.length) return Integer.MIN_VALUE;
      if(dp[index][count] != -1) return dp[index][count];
      int take_index = windows[index] + helper(windows,count - 1,index + k,k);
      int not_take_index = helper(windows,count,index+1,k);
      return dp[index][count] = Math.max(take_index,not_take_index);
  }































  private int[] max(int[] nums,int k){
    int n = nums.length;
    int m = n - k + 1;
    int[] win = new int[m];
    int j = 0,i=0,sum = 0;
    while(j < n){
      sum+=nums[j];
      if(j - i + 1 == k){
        win[i] = sum;
        sum-=nums[i++];
      }
      j++;
    }
    int[][] dp = new int[nums.length+1][4];
    for(int[] d : dp) Arrays.fill(d,-1);
    List<Integer> ans = new ArrayList<>();
    solve_1(win,0,3,k,ans,dp);
    return ans.stream().mapToInt(Integer::intValue).toArray();
  }



  private void solve_1(int[] win, int index,int count, int k, List<Integer> list,int[][] dp){
    if(index >= win.length || count == 0) return;
    int take = win[index] + helper(index+k,count - 1,k,win,dp);
    int not_take = helper(index,count,k,win,dp);
    if(take >= not_take){
      list.add(index);
      solve_1(win,index+k,count-1,k,list,dp);
    }else{
      solve_1(win,index+1,count,k,list,dp);
    }
  }

  private int helper(int index,int count,int k,int[] win,int[][] dp){
    if(count == 0) return 0;
    if(index >= win.length) return Integer.MIN_VALUE;
    if(dp[index][count] != -1) return dp[index][count];
    int take = win[index] + helper(index+k,count - 1,k,win,dp);
    int not_take = helper(index+1,count,k,win,dp);
    return dp[index][count] = Math.max(take,not_take);
  }

}
