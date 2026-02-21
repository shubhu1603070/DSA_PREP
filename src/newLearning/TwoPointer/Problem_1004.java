package newLearning.TwoPointer;

import java.util.LinkedList;
import java.util.Queue;

public class Problem_1004 {

    public static void main(String[] args) {

        System.out.println(test(new int[]{1,1,1,0,0,0,1,1,1,1,0},2));
        System.out.println(test(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1},3));
        System.out.println(test(new int[]{0,0,0,1},4));

    }


    public static int test(int[] nums, int k) {

        int initialK = 0;
        int n = nums.length;
        int left = 0;
        int right = 0;
        int maxLen = Integer.MIN_VALUE;
        while(right < n) {
            if(nums[right] == 0) initialK++;
            if(initialK > k){
                while(left <= right && initialK > k){
                    if(nums[left] == 0) initialK--;
                    left++;
                }
            }
            maxLen = Math.max(maxLen, right - left);
            right++;
        }

        return maxLen + 1;

    }


}
