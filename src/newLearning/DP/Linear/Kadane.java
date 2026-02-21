package newLearning.DP.Linear;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Kadane {

  public static void main(String[] args) {
    maxProduct(new int[]{2,3,-2,4});
    maxProduct(new int[]{-2,3,-4});
  }

  static int res = 0;
  static public int maxProduct(int[] nums) {
    int n = nums.length;
    res = 0;
//    if(n == 1) return nums[0];
//    int pre = 1;
//    int res = Integer.MIN_VALUE;
//    for(int i = 0; i < n;i++){
//      int take = nums[i] * pre;
//    }
    maxProduct2(nums,0,n);
    System.out.println(res);
    return res;
  }

  static public int maxProduct2(int[] nums,int index,int n) {
    if(index >= n) return 1;
    int take = nums[index]*maxProduct2(nums,index+1,n);
    int not_take = maxProduct2(nums,index+1,n);
    res = take > not_take ? (Math.max(take, res)) : (Math.max(not_take, res));
    return Math.max(take,not_take);
  }

  private int justFun(int[] nums){
    int n = nums.length;
    int ans = Integer.MIN_VALUE;
    for(int i=0;i<n;i++){
      int cur = 1;
      for(int j = i+1;j<n;j++){
        cur = cur*nums[j];
        ans = Math.max(ans,cur);
      }
    }
    return ans;
  }

  public int maxProduct2(int[] nums) {
    int n = nums.length;
    List<Integer> list = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();

    for(int i = 0;i<n;i++){
      if(nums[i] < 0) list.add(i);
      if(nums[i] > 0)  list2.add(i);
    }

    int cur = 1;
    int cur1 = 1;
    int ans = Integer.MIN_VALUE;
    for(int i = 0;i<n;i++){
      if(!list2.isEmpty() && list2.getFirst() == i){
        cur *= nums[list2.removeFirst()];
        ans = Math.max(ans,cur);
      }else{
        cur = 1;
      }

      if(!list.isEmpty() && list.getFirst() == i){
        cur1 *=  nums[list.removeFirst()];
        ans = Math.max(ans,cur);
      }else{
        cur1 = 1;
      }
      ans = Math.max(ans,nums[i]);
    }

    System.out.println(ans);

    return ans;

  }

  public int findTargetSumWays(int[] nums, int target) {
    return dfs(nums,target,0);
  }

  private int dfs(int[] nums,int target,int index){
    if(index >= nums.length) return 0;
    if(target == nums[index]) return 1;
    return dfs(nums,nums[index] + target,index+1)+dfs(nums,-nums[index] + target,index+1);
  }


  private int bottomUP(int[] c,int a){
    int n = c.length;
    int[][] dp = new int[n+1][a+1];
    Arrays.fill(dp[0],1);
    for(int i = 1;i<=n;i++){
      for(int j = i;j<=a;j++){
        if(j >= c[i-1]){
          dp[i][j] = dp[i-1][j] +  dp[i-1][j-c[i-1]];
        }else{
          dp[i][j] = dp[i-1][j];
        }
      }
    }
    return dp[n][a];
  }


  private int subSetSum(int[] nums){
    int total = Arrays.stream(nums).sum();
    boolean[][] dp = new boolean[nums.length+1][total+1];
    for(int i = 0;i<=nums.length;i++) dp[i][0] = true;

    for(int i = 1;i<=nums.length;i++){
      for(int j = 1;j<=total;j++){
        if(j >= nums[i-1]){
          dp[i][j] = dp[i-1][j] ||  dp[i-1][j-nums[i-1]];
        }else{
          dp[i][j] = dp[i-1][j];
        }
      }
    }

    int min = Integer.MAX_VALUE;
    for(int i = total / 2;i>=0;i--){
      if(dp[nums.length][i])
        min = Math.min(2*i,min);
    }
    int n = 0;
    List<Integer> list = new ArrayList<>();
    for(int i = 0;i<n;i++){
      int sqrt = ((int) Math.sqrt(i));
      if(sqrt * sqrt == i) list.add(i);
    }

    int[] array = list.stream().mapToInt(Integer::intValue).toArray();

    return min;
  }

}
