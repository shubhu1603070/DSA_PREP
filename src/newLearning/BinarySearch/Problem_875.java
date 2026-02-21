package newLearning.BinarySearch;

import java.util.Arrays;

public class Problem_875 {

    static int test(int[] nums,int h){
        int low = 0;
        int high = Arrays.stream(nums).max().getAsInt();
        while(low < high){
            int mid = low + (high - low)/2;
            if(check(mid,nums,h)){
                high = mid;
            }else low = mid+1;
        }
        return low;
    }

    static boolean check(int mid,int[] nums,int h){
        int totalH = 0;
        for(int ele : nums){
            totalH += ((int) Math.ceil((double) ele / mid));
        }
        return totalH <= h;
    }


}
