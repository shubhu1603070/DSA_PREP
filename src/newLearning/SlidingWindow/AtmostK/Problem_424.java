package newLearning.SlidingWindow.AtmostK;

import java.util.*;

public class Problem_424 {


    public static int test(String s, int k) {
        int right = 0;
        int left = 0;
        int n = s.length();
        int result = 0;
        int[] need = new int[26];
        int maxFreq = 0;
        while (right < n) {
            char c = s.charAt(right);
            need[c - 'A']++;

            maxFreq = Math.max(maxFreq, need[c - 'A']);
            while((right - left + 1) <= k){
                need[s.charAt(left) - 'A']--;
                left++;
            }

            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }

}
