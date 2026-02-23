package newLearning.SlidingWindow.MonotonicQueuePlusWindow;

import java.util.*;

public class Problem_239 {

    public static void main(String[] args) {
        test(new int[]{1,3,-1,-3,5,3,6,7},3);
    }


    public static int[] test(int[] nums,int k){
        int right = 0;
        int left = 0;
        //monotonic stack
        Deque<Integer> queue = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];

        while(right < nums.length){
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[right]){
                queue.removeLast();
            }
            queue.offerLast(right);
            if(!queue.isEmpty() && queue.peekFirst() <= right - k){
                queue.removeFirst();
            }


            if(!queue.isEmpty() && right >= k-1){
                res[left++] =  nums[queue.peekFirst()];
            }
            right++;
        }

        return res;
    }

}
