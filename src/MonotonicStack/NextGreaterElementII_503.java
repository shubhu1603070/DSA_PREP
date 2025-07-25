package MonotonicStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementII_503 {

    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int length = nums.length;
        int[] nge = new int[length];
        for(int i=(2 * length)-1; i >= 0; i--){
            while (!stack.isEmpty() && stack.peek() <= nums[i% length]) stack.pop();
            if(i<length){
                nge[i] = stack.empty() ? -1 : stack.peek();
            }
            stack.push(nums[i%length]);
        }
        return nge;
    }

}
