package newLearning.TwoPointer;

public class Problem_643 {


    public double findMaxAverage(int[] nums, int k) {
        long result = 0;
        int sum = 0;
        int start = 0;
        for(int index = 0; index < k; index++){
            sum+=nums[index];
        }
        result = sum;
        for(int index = k; index < nums.length; index++){
            sum -= nums[start++];
            sum += nums[index];
            result = Math.max(result, sum);
        }
        return (double) result / k;

    }

}
