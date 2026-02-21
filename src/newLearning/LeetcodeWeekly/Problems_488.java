package newLearning.LeetcodeWeekly;

import java.util.*;

public class Problems_488 {

  public static void main(String[] args) {
    Problems_488 p = new Problems_488();
//        p.dominantIndices(new int[]{5,4,3});
//        p.dominantIndices(new int[]{4,1,2});
//        p.countSubarrays(new int[]{1,3,2},4);
//        p.countSubarrays(new int[]{1,2,3},4);
//        p.countSubarrays(new int[]{5,5,5,5,5},0);
//        p.mergeAdjacent(new int[]{3,1,1,2});
//        p.mergeAdjacent(new int[]{2,2,4});
        p.maxScore(new int[]{1,3,2},new int[]{4,5,1},2);
  }


  public int dominantIndices(int[] nums) {
    int[] sum = new int[nums.length];
    int n = nums.length;
    sum[n-1] = nums[n-1];
//    System.out.println(Arrays.toString(sum));
    for(int i = n-2;i >= 0;i--){
      sum[i] = sum[i+1]+nums[i];
    }

//    for(int i = nums.length-2;i>=0;i--){
//      sum[i]+=nums[i+1];
//    }
    int count = 0;
//    System.out.println(Arrays.toString(sum));
    for(int i = 1;i<n;i++){
//      System.out.println("nums : "+nums[i-1] +" : "+(sum[i]/(n-i)));
      if(nums[i-1] > (sum[i] / (n - i))){
        count++;
      }
    }
//    System.out.println(count);
    return count;
  }

  public List<Long> mergeAdjacent(int[] nums) {
    Stack<Long> stack = new Stack<>();
    for (int num : nums) {
      if (!stack.isEmpty() && stack.peek() == num) {
        long sum = (long) num;
        while (!stack.isEmpty() && stack.peek() == sum) {
          sum *= 2;
          stack.pop();
        }
        stack.push(sum);
      } else {
        stack.push((long) num);
      }
    }
    return stack.stream().toList();
  }

  public long countSubarrays(int[] nums, long k) {
    long answer = 0;
    int n = nums.length;
    int left = 0;
    int right = 0;
    Deque<Integer> min = new ArrayDeque<>();
    Deque<Integer> max = new ArrayDeque<>();
    for(;right < n;right++){

      while(!max.isEmpty() && nums[max.peekLast()] <= nums[right]){
        max.pollLast();
      }
      max.offerLast(right);

      while(!min.isEmpty() && nums[min.peekLast()] >= nums[right]){
        min.pollLast();
      }
      min.offerLast(right);

      while(left <= right && !min.isEmpty() && !max.isEmpty()){
        long diff = (long) nums[max.peekFirst()] - nums[min.peekFirst()];
        long len = right - left + 1L;
        long cost = diff * len;
        if(cost <= k) break;
        if(max.peekFirst() == left) max.pollFirst();
        if(!min.isEmpty() && min.peekFirst() == left) min.pollFirst();
        left++;
      }

      answer += right - left + 1L;

    }

    System.out.println(answer);
    return answer;
  }

  public long maxScore(int[] nums1, int[] nums2, int k) {
    long[][][] dp = new long[101][101][101];
    for(long[][] d : dp){
      for(long[] a : d){
        Arrays.fill(a,(long) 1e17);
      }
    }
    return dfs(0,0,nums1,nums2,k,dp);
  }

  private long dfs(int n1, int n2, int[] nums1, int[] nums2, int k,long[][][] dp) {
    if(n1 >= nums1.length || n2 >= nums2.length) {
      if(k == 0) return 0L;
      else return (long) -1e15;
    }
    if(k == 0) return 0L;
    if(dp[n1][n2][k] != 1e17) return dp[n1][n2][k];
    long s1 = Integer.MIN_VALUE,s2, s3;
    s1 = (long) nums1[n1] * nums2[n2] + dfs(n1+1,n2+1,nums1,nums2,k-1,dp);
    s2 = dfs(n1+1,n2,nums1,nums2,k,dp);
    s3 = dfs(n1,n2+1,nums1,nums2,k,dp);
    return dp[n1][n2][k] = Math.max(s1,Math.max(s2,s3));
  }

}
