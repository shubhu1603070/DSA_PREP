package newLearning.TwoPointer;

import java.util.Arrays;

public class Problem_567 {

    public boolean checkInclusion(String s1, String s2) {
        int[] map = new int[26];
        for(Character c : s1.toCharArray()){
            map[c-'a']++;
        }
        int chars = s1.length();
        int i = 0;
        int j = 0;
        while(j < s2.length()){
            System.out.println(Arrays.toString(map));
            if(map[s2.charAt(j)-'a']-- >= 0){
                chars--;
            }
            if(chars==0){
                return true;
            }
            if(j-i >= s1.length() && map[s2.charAt(i++)-'a']++ >= 0){
                chars--;
            }
        }
        return false;
    }

}
