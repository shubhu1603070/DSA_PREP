package newLearning.TwoPointer;

import java.util.Arrays;

public class Problem_992 {


    public static void main(String[] args) {
        System.out.println(test(new int[]{1,2,1,2,3},2) - test(new int[]{1,2,1,2,3},1));
        test(new int[]{1,2,1,3,4},3);
        test(new int[]{1,2,1,3,1,4},3);
    }

    public static int test(int[] arr,int k){
        int right = 0;
        int left = 0;
        int[] need = new int[9];
        int ok = 0;
        int n = arr.length;
        int result = 0;
        while(right<n){
            if(need[arr[right]]==0){
                ok++;
            }
            need[arr[right]]++;
            while(ok > k && left <= right){
                need[arr[left]]--;
                if(need[arr[left]] == 0){
                    ok--;
                }
                left++;
            }
            result += (right - left + 1);
            right++;
        }
        return result;
    }

}
