package newLearning.TwoPointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem_3 {



    public static void main(String[] args) {
        Problem_3 p = new Problem_3();
        p.lengthOfLongestSubstring("bbbbb");
        p.lengthOfLongestSubstring("abcabcbb");
        p.lengthOfLongestSubstring("pwwkew");
    }

    public int lengthOfLongestSubstring(String s) {
        int left = 0,right = 0;
        int n = s.length();
        int result = 0;
        Map<Character,Integer> map = new HashMap<>();

        while(right<n){
            if(map.containsKey(s.charAt(right))){
                left = Math.max(left,map.get(s.charAt(right)));
            }
            map.put(s.charAt(right),right+1);
            right++;
            result = Math.max(result,right-left);
        }

        System.out.println(result);

        return result;

    }

}
