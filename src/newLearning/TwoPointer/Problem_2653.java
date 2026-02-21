package newLearning.TwoPointer;

import java.util.*;
import java.util.stream.Collectors;

public class Problem_2653 {


    //This is incomplete need to do it later on

    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int[] result = new int[nums.length-k+1];
        Set<Integer> set = new TreeSet<>();
        int index = 0;
        int start = 0;
        int end = 0;
        while(end < nums.length){
            if(end - start + 1 == k){
                int[] array = set.stream().parallel().mapToInt(Integer::intValue).toArray();
                result[index++] = array[Math.abs(array.length-x)];
                set.remove(nums[start]);
            }
            set.add(nums[end]);
            end++;
        }
        return result;
    }

}
