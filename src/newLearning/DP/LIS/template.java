package newLearning.DP.LIS;

import java.util.ArrayList;
import java.util.List;

public class template {


    //O(n*logn)
    public List<Integer> getLongestIncreasingSubsequence(int[] nums){
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int index = binarySearch(res,nums[i]);
            if(index == res.size()){
                res.add(nums[i]);
            }else{
                res.set(index,nums[i]);
            }
        }
        System.out.println(res);
        return res;
    }

    private int binarySearch(List<Integer> res, int num) {

        int left = 0,right = res.size();
        int data = 0;
        while(left < right){
            int mid = left + (right - left)/2;
            if(res.get(mid) < num){
                left = mid + 1;
            }else{
                data = right = mid;
            }
        }
        return (data < res.size() && res.get(data) == num) ? res.get(data) : res.size();
    }


}
