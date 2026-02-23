package newLearning.SlidingWindow.OrderStatistics;

import java.util.*;

public class Problem_480 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(test(new int[]{1,3,-1,-3,5,3,6,7},3)));
        System.out.println(Arrays.toString(test(new int[]{1,2,3,4,2,3,1,4,2},3)));
        System.out.println(Arrays.toString(test(new int[]{2147483647,2147483647},2)));
    }

    //Giving TLE
    public static double[] test(int[] nums, int k) {
        boolean isEven = k % 2 == 0;

        int right = 0;
        int left = 0;
        int n = nums.length;
        int idx = 0;
        double[] ans = new double[n - k + 1];
        int[] arr;
        while(right < n){

            while((right - left + 1) > k){
                left++;
            }

            if(right - left + 1 == k){
                arr = Arrays.copyOfRange(nums, left, right  + 1);
                Arrays.sort(arr);
                System.out.println(Arrays.toString(arr));
                int newIndex = k / 2;
                if(isEven){
                    ans[idx++] = (double) (arr[newIndex] % 10e9 + arr[newIndex - 1] % 10e9) / 2;
                }else{
                    ans[idx++] = arr[newIndex];
                }
            }
            right++;
        }
        return ans;
    }


//    public static double[] testMinHeap(int[] nums, int k) {
//        Queue<Integer> max = new PriorityQueue<>();
//        Queue<Integer> min = new PriorityQueue<>(Collections.reverseOrder());
//        double[] ans = new double[nums.length - k + 1];
//
//        int right = 0;
//
//        while(right < nums.length){
//
//            if(min.isEmpty() || nums[min.peek()] >= nums[right]){
//                min.offer(right);
//
//            }
//        }
//
//    }

}
