package newLearning.TwoPointer;

public class Problem_1343 {


    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int result = 0;
        int sum = 0;
        int start = 0;
        for(int index = 0;index < k;index++) sum+=arr[index];
        for(int index = k;index<arr.length;index++) {
            System.out.println("start : "+start+" index : "+index+" sum : "+sum+" threshold : "+(sum/k));
            result += sum / k >= threshold ? 1 : 0;
            sum-=arr[start++];
            sum+=arr[index];
        }
        return result += sum / k >= threshold ? 1 : 0;
    }

}
