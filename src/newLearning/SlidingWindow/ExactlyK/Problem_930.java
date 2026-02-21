package newLearning.SlidingWindow.ExactlyK;

public class Problem_930 {

    public static void main(String[] args) {
        System.out.println(numSubarraysWithSum(new int[]{1,0,1,0,1},2));
    }


    public static int numSubarraysWithSum(int[] nums, int goal) {
        return test(nums,goal) - test(nums,goal-1);
    }

    public static int test(int[] f,int k) {
        int right = 0;
        int left = 0;
        int sum = 0;
        int result = 0;
        while (right < f.length) {

            sum += f[right];

            while (sum > k && left <= right) {
                sum -= f[left++];
            }

            result += (right - left + 1);

            right++;
        }

        return result;
    }
}
