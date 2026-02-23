package MonotonicStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI_496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>();
        //NGL
        for(int num : nums2){
            while (!stack.isEmpty() && stack.peek() < num) map.put(stack.pop(),num);
            stack.push(num);
        }
        for (int index = 0; index < nums1.length; index++) {
            nums1[index] = map.getOrDefault(nums1[index],-1);
        }
        return nums1;
    }


}
