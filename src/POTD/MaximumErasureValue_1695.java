package DailyChallenge;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MaximumErasureValue_1695 {

    public int maximumUniqueSubarray(int[] nums) {

        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int index = 1; index < nums.length; index++) {
            prefixSum[index]=(prefixSum[index-1]+nums[index]);
        }
        System.out.println(Arrays.toString(prefixSum));

        int start = 0;
        int end = 1;
        int max = Integer.MIN_VALUE;
        boolean flag = false;
        List<Integer> list = new ArrayList<>();
        while(end<nums.length){
            System.out.println("Element : "+nums[end]+" max : "+max);
            if(list.contains(nums[end])){
                int index = list.indexOf(nums[end]);
                list = list.subList(index, end);
//                Stream.of(list).map(Integer::sum);
                System.out.println("Index : "+index+" Array : "+list);
                start = index;
            }
            list.add(nums[end]);
            System.out.println("Start : "+start);
            max = Math.max(max,prefixSum[end]-(start > 1 ? prefixSum[start-1] : 0));
            end++;
        }
        return max;
//        return !flag ? prefixSum[nums.length-1] : max;
    }

}
