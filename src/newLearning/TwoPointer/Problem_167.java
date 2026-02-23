package newLearning.TwoPointer;

public class Problem_167 {

    public int[] twoSum(int[] numbers, int target) {
        int i  = 0;
        int j = numbers.length - 1;
        int[] result = new int[]{-1,-1};

        while(i<j){
            if(numbers[i]+numbers[j]==target){
                result[0] = i;
                result[1] = j;
            }else if(numbers[i]+numbers[j]<target){
                j--;
            }else{
                i++;
            }
        }

        return result;

    }

}
