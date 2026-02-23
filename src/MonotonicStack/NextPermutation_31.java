package MonotonicStack;

import java.lang.reflect.Array;
import java.util.Arrays;

public class NextPermutation_31 {

    public void nextPermutation(int[] nums) {
        int start = nums.length-2;

        while ((start>=0 && nums[start]>=nums[start+1])) start--;

        int end = nums.length-1;

        while (start >= 0 && nums[end]<=nums[start]) end--;

        if(start>=0){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
        end = nums.length-1;
        start = start+1;
        while (start<=end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
