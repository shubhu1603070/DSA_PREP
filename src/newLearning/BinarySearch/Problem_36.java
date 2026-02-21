package newLearning.BinarySearch;

import java.util.Arrays;

public class Problem_36 {


    public static void main(String[] args) {

    }

    static int test(int[] nums,int target){
        int low = 0;
        int high = nums.length-1;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                high = mid-1;
            }else{
                low = mid + 1;
            }
        }

        return low;

    }

    static int[] test1(int[] nums,int target){
        int low = 0;
        int high = nums.length-1;
        int[] arr = {-1,-1};
        while(low < high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(nums[mid-1] >= target){
                    arr[1] = mid;
                    high = mid-1;
                }else{
                    arr[0] = mid;
                    low = mid+1;
                }
            }else if(nums[mid] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        if (arr[0] == -1 && arr[1] > -1) {
            return new int[]{arr[1], arr[1]};
        } else if (arr[0] > -1 && arr[1] == -1) {
            return new int[]{arr[0], arr[0]};
        } else return new int[]{-1, -1};
    }


    public int shipWithinDays(int[] weights, int days) {
        int low = Arrays.stream(weights).max().getAsInt();
        int high = Arrays.stream(weights).sum();

        while(low < high){
            int mid = low + (high - low)/2;
            if(check(weights,days,mid)){
                high = mid;
            }else {
                low = mid+1;
            }
        }
        return low;
    }

    private boolean check(int[] weights, int days, int low){
        int iH = 0;
        for(int weight : weights){
            iH += (int) Math.ceil(weight/(double)low);
            if(iH > days) return false;
        }
        return true;
    }

}
