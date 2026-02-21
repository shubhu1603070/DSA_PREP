package newLearning.SlidingWindow.ValidityOrFrequencyMatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem_438 {


    public static List<Integer> test(String s,String p){
        if(s.length() < p.length()) return Collections.emptyList();
        int right = 0;
        int left = 0;
        int sn = s.length();
        int result = 0;
        int[] need = new int[26];
        int pn = p.length();
        List<Integer> ans = new ArrayList<>();
        for(char ch : p.toCharArray()){
            need[ch - 'a']++;
        }

        while(right < sn){
            if(--need[s.charAt(right)-'a'] >= 0) result++;
            if((right - left + 1) > pn){
                if(++need[s.charAt(left++)-'a'] > 0) result--;
            }
            if(result == pn){
                ans.add(left);
            }
            right++;
        }
        return ans;
    }

}
