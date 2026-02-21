package newLearning.TwoPointer;

import java.util.*;

public class Problem_239 {


    //this one is incomplete
    public int[] maxSlidingWindow(int[] nums, int k) {
        int max = 0;
        Deque<Integer> q = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<k; i++){
            q.add(nums[i]);
            max = Math.max(max, nums[i]);
        }
        list.add(max);
        for(int i=k; i<nums.length; i++){
            int first = q.removeFirst();
            q.add(nums[i]);
            if(first == max){
                while(!q.isEmpty()){
                    first = q.removeFirst();
                    max = Math.max(max, nums[first]);
                }
            }
            list.add(max);
        }
        return list.stream().parallel().mapToInt(Integer::intValue).toArray();
    }

}
