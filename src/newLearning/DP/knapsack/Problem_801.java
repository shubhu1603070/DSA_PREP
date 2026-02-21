package newLearning.DP.knapsack;

import java.util.Arrays;

import static java.util.Collections.swap;

public class Problem_801 {

  public static void main(String[] args) {
    System.out.println(minSwap(new int[]{1,3,5,4},new int[]{1,2,3,7}));
    System.out.println(minSwap(new int[]{12, 14, 15, 16, 19, 20},new int[]{11, 17, 18, 19, 20, 21}));
    System.out.println(minSwap(new int[]{0,7,8,10,10,11,12,13,19,18},new int[]{14,4,5,7,11,14,15,16,17,20}));
  }

  static int max = (int) 1e6;
  static public int minSwap(int[] nums1, int[] nums2) {
    return dfs(nums1,nums2,0,-1,-1);
  }

  static private int dfs(int[] n1,int[] n2,int idx,int n1p,int n2p) {
    if(idx >= n1.length)
      return 0;
    //What if i try to swap with the index
    //what if i don't swap at current index;
    int min = max;
    if(n1[idx] > n1p && n2[idx] > n2p)
      min = dfs(n1,n2,idx+1,n1[idx],n2[idx]);
    if(n2[idx] > n1p && n1[idx] > n2p)
      min = Math.min(dfs(n1,n2,idx+1,n2[idx],n1[idx])+1,min);
    return min;
  }

}
