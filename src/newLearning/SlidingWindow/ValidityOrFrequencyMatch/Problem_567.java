package newLearning.SlidingWindow.ValidityOrFrequencyMatch;

import java.util.*;

public class Problem_567 {


    public static boolean test(String s2, String s1){
        int match = 0;
        int[] need = new int[26];
        int right = 0;
        int left = 0;
        boolean flag = false;
        for(char ch : s2.toCharArray()){
            need[ch-'a']++;
        }

        while(right < s1.length()){

            if(--need[s1.charAt(right) - 'a'] >= 0) match++;

            if((right - left + 1) > s2.length())
                if(++need[s1.charAt(left++) - 'a'] > 0) match--;

            if(match == s2.length()) {
                flag = true;
                break;
            }
            right++;
        }

        return flag;

    }

}
