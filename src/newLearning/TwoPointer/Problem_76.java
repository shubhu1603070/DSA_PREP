package newLearning.TwoPointer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Problem_76 {


    public static void main(String[] args) {
        Problem_76 p = new Problem_76();
        System.out.println(p.minWindow("ADOBECODEBANC","ABC"));
        System.out.println(p.minWindow("A","AA"));
        System.out.println(p.minWindow("A","A"));
        System.out.println(p.minWindow("A","B"));
    }


    public String minWindow(String s, String t) {

        if(s.length() < t.length()) return "";

        Map<Character, Integer> map = new HashMap<>();
        int[] need = new int[128];
        int n = s.length();
        int right = 0;
        int left = 0;
        int start = 0;
        int maxLEn = (int) 10e7;
        int cnt = 0;

        for(Character ch : t.toCharArray()){
            need[ch]++;
        }

        while(right < n){
            char c = s.charAt(right);

            if(need[c] > 0){
                cnt++;
            }
            need[c]--;

            right++;
            while (cnt == t.length()){
                if(maxLEn > right-left){
                    start = left;
                    maxLEn = right-left;
                }
                char ch = s.charAt(left);
                need[ch]++;
                if(need[ch] > 0){
                    cnt--;
                }
                left++;
            }
        }
        return maxLEn == (int) 10e7 ? "" : s.substring(start, start+maxLEn);
    }

}
