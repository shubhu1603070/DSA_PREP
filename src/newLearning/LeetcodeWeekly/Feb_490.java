package newLearning.LeetcodeWeekly;

import java.lang.reflect.Array;
import java.util.*;

public class Feb_490 {

  public static void main(String[] args) {
//    System.out.println(scoreDifference(new int[]{2,4,2,1,2,1}));
//    System.out.println(scoreDifference(new int[]{1,2,1}));
//    System.out.println(scoreDifference(new int[]{1,2,3}));
//    System.out.println(scoreDifference(new int[]{1,2,1,1,2,1,6,4,1}));
//    System.out.println(scoreDifference(new int[]{1}));

//    System.out.println(isDigitorialPermutation(145));
//    System.out.println(isDigitorialPermutation(10));
//    System.out.println(isDigitorialPermutation(415));


//    System.out.println(maximumXor("0110","1110"));
//    System.out.println(maximumXor("10","01"));
//    System.out.println(maximumXor("0101","1001"));


//    System.out.println(countSequences(new int[]{2,3,2},6));
//    System.out.println(countSequences(new int[]{4,6,3},2));
  }

  static public int scoreDifference(int[] nums) {
    int a  = 0;
    int position = 0;
    int sum = 0;
    boolean flag = true;

    for(int ele : nums){
      sum += ele;
      if(++position == 6){
        position = 0;
        flag = !flag;
      }
      if((ele & 1) == 1){
        flag = !flag;
      }
      if(flag) a+=ele;
    }
    int b = sum - a;
    return a - b;
  }

  static public boolean isDigitorialPermutation(int n) {
    String str = String.valueOf(n);
    long[] dp = new long[10];
    char[] arr = new char[10];
    long sum = 0;
    for(char ch : str.toCharArray()){
      if(dp[ch - '0'] == 0) {
        dp[ch - '0'] = factorial(ch - '0');
      }
      sum += dp[ch - '0'];
      arr[ch - '0']++;
    }
    char[] arr1  = new char[10];
    for(char ch : String.valueOf(sum).toCharArray()){
      arr1[ch - '0']++;
    }
    int i = 0;
    while(i < 10){
      if(arr[i] != arr1[i]){
        return false;
      }
      i++;
    }

    return true;
  }

  static public long factorial(int n) {
    long result = 1;
    for(int i = 1; i <= n; i++) {
      result *= i;
    }
    return result;
  }

  static public String maximumXor(String s, String t) {
    StringBuilder stringBuilder = new StringBuilder();

    int numberOfOnes = 0;
    for(char ch : t.toCharArray()){
      numberOfOnes += ch == '1' ? 1 : 0;
    }

    int numberOfZeros = t.length()-numberOfOnes;
    int index = 0;

    System.out.println("numberOfOnes: " + numberOfOnes+" numberOfZeros: " + numberOfZeros);

    while(index < s.length()){

      char ch = s.charAt(index);

      if(ch == '1'){
        if(numberOfZeros > 0){
          stringBuilder.append('1');
          numberOfZeros--;
        }else{
          stringBuilder.append('0');
        }
      }else{
        if(numberOfOnes > 0){
          stringBuilder.append('1');
          numberOfOnes--;
        }else{
          stringBuilder.append('0');
        }
      }

      index++;
    }

    return stringBuilder.toString();

  }

  static public int countSequences(int[] nums, long k) {
    Map<String, Integer> memo = new HashMap<>();
    return solve(nums, k, 0, 1L, 1L, memo);
  }

  static private int solve(int[] nums, long k, int index,int den,int num,int[][][] dp){
    if(index >= nums.length){
      return (den / num == k) ?  1 : 0;
    }
    if(dp[index][num][den] != -1) return dp[index][num][den];
    return dp[index][num][den] = solve(nums,k,index+1,den,num,dp) + solve(nums,k,index+1,den,num * nums[index],dp) + solve(nums,k,index+1,den * nums[index],num,dp);
  }

  static private int solve(int[] nums, long k, int index, long den, long num, Map<String, Integer> memo) {
    if (index >= nums.length) {
      return (den == k * num) ? 1 : 0;
    }

    String state = index + "," + den + "," + num;
    if (memo.containsKey(state)) return memo.get(state);

    int res = solve(nums, k, index + 1, den, num, memo);

    res += solve(nums, k, index + 1, den, num * nums[index], memo);

    res += solve(nums, k, index + 1, den * nums[index], num, memo);

    memo.put(state, res);
    return res;
  }
}
