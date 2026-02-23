package newLearning.TwoPointer;

import java.util.*;

public class Problem_2461 {

    public long maximumSubarraySum(int[] nums, int k) {
        long result = 0;
        int end = 0;
        int start = 0;
        long sum = 0;
        Set<Integer> list = new HashSet<>();

        while(end < nums.length){
            while(list.contains(nums[end])){
                sum-=nums[start];
                list.remove(nums[start]);
                start++;
            }
            sum+=nums[end];
            list.add(nums[end]);
            if(end - start + 1 == k){
                result = Math.max(result,sum);
                sum-=nums[start];
                list.remove(nums[start]);
                start++;
            }
            end++;
        }
        return result;
    }

}
