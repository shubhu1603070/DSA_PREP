package newLearning.DP.Linear;

import Trees.TreeNode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Fibonacci {

  public static void main(String[] args) {
    System.out.println(fib(5));
    int[] dp = new int[6];
    Arrays.fill(dp,-1);
    dp[0] = 0;
    dp[1] = 1;
    fibMemo(5,dp);
    System.out.println(dp[5]);
  }

  static public int fib(int n){
    if(n == 0) return 0;
    if(n == 1) return 1;
    return fib(n -1)+ fib(n-2);
  }

  static public int fibMemo(int n,int[] dp){
    if(dp[n] != -1)  return dp[n];
    return dp[n] = fibMemo(n-1, dp) + fibMemo(n-2, dp);
  }

  static public int finDP(int n){
    int[] dp = new int[n+1];
    dp[0] = 0;
    dp[1] = 1;
    for(int i = 2; i <= n; i++){
      dp[i] = dp[i-1] + dp[i-2];
    }
    return dp[n];
  }

  static public int fibDP_(int n){
    if(n == 0) return 0;
    int lastPrev = 0;
    int currentPrev = 1;
    int result = lastPrev + currentPrev;
    for(int i = 2; i <= n; i++){
      result = currentPrev + lastPrev;
      lastPrev = currentPrev;
      currentPrev = result;
    }
    return result;
  }

  public int rob(int[] nums) {
    int n = nums.length;
    if(n == 1) return nums[0];
    return Math.max(max(nums,0,n-1),max(nums,1,n));
  }

  public int max(int[] nums,int start,int end) {
    int skip = 0;
    int take = nums[start];
    for(int i = start;i < end; i++){
      int max = Math.max(skip,take);
      take = skip + nums[i];
      skip = max;
    }
    return Math.max(skip,take);
  }

  public int rob(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
    queue.add(null);
    int skip = 0;
    int take = 0;
    int finalResult = 0;
    while(!queue.isEmpty()){;
      TreeNode cur = queue.poll();
      int result = cur.val;
      int temp = 0;
      skip = take;
      while(cur != null){
        skip = Math.max(skip,result);
        take = cur.val + temp;
        temp = take;
        if(cur.left != null) queue.add(cur.left);
        if(cur.right != null) queue.add(cur.right);
        cur = queue.poll();
      }
      if(!queue.isEmpty()) queue.add(null);
    }
    return Math.max(skip,take);
  }


}
