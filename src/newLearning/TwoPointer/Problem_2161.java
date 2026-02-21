package newLearning.TwoPointer;

public class Problem_2161 {

    public int[] pivotArray(int[] nums, int pivot) {
        int k = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == pivot){
                k = i;
                break;
            }
        }


        int j = k+1;
        int i = 0;

        while(i < nums.length){
            if(nums[i] <= pivot){
                i++;
            }else if(nums[j] < pivot && nums[i] > nums[j]){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }else if(nums[j] < nums[i]){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
            }
        }

        return nums;

    }


}
