package newLearning.Backtracking;

import java.util.Arrays;

public class Problem_1745 {

    boolean[][] it = null;
    public static void main(String[] args) {
        Problem_1745 p = new Problem_1745();
        p.checkPartitioning("abcbdd");
    }

    public boolean checkPartitioning(String s) {
        it = new boolean[s.length()][s.length()];
        isPalindrome_(s,0,s.length()-1);
        for(boolean[] a : it){
            System.out.println(Arrays.toString(a));
        }
        return true;
    }

    private void isPalindrome_(String str,int low,int high){
        char[] ch = str.toCharArray();
        for(int i = high ; i > 0;i--){
            for(int j = i;j<high + 1;j++){
                if(ch[i] == ch[j]) it[i][j] = true;
                else it[i][j] = false;
            }
        }
    }



}
