package newLearning.TwoPointer;

import java.util.Arrays;

public class Problem_2592 {

    public static void main(String[] args) {
        int[] arr = new int[]{42,8,75,28,35,21,13,21};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        Problem_2592 p = new Problem_2592();
        System.out.println(p.maximizeGreatness(new int[]{2,8,75,28,35,21,13,21}));
    }

    public int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);
        int j = 0;
        while(j < nums.length-1){
            if(nums[0] != nums[j]) break;
            j++;
        }
        int i = 0;
        int result = 0;
        while(j < nums.length-1){
//            System.out.println(nums[i] +" : "+nums[j]);
            if(nums[i] < nums[j]) {
                result++;
                i++;
                j++;
            }else{
                j++;
            }
        }
        return result;
    }

}
