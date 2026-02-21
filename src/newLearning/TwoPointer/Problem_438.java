package newLearning.TwoPointer;

import java.util.ArrayList;
import java.util.List;

public class Problem_438 {

    public List<Integer> findAnagrams(String s, String p) {
        int[] map = new int[26];
        int i = 0,j = 0;
        for(Character c: p.toCharArray()){
            map[c-'a']++;
        }
        int chars = p.length();
        List<Integer> ans = new ArrayList<>();
        while(j < s.length()){
            System.out.println("inital: "+s.substring(i,j));
            if(map[s.charAt(j++)-'a']-- > 0){
                chars--;
            }
            if(chars == 0){
                System.out.println(s.substring(i,j));
                ans.add(i);
            }
            if((j-i) >= p.length() && map[s.charAt(i++)-'a']++ >= 0){
                chars++;
            }
            System.out.println(chars);
        }
        return ans;
    }

}
