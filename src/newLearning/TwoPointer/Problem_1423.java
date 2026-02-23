package newLearning.TwoPointer;

import java.util.Arrays;

public class Problem_1423 {

    public int maxScore(int[] cardPoints, int k) {
        int end = cardPoints.length - 1;
        int result = 0;
        int suffixSum = 0;
        int prefixSum = 0;

        for(int index = 0;index<k;index++){
            suffixSum+=cardPoints[index];
        }
        result = suffixSum;
        for(int index = k-1;index >= 0;index--){
            suffixSum-=cardPoints[index];
            prefixSum+=cardPoints[end--];
            result = Math.max(result,suffixSum+prefixSum);
        }
        return result;
    }

}
