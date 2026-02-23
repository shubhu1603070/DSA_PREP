package newLearning.Recursion;

import java.util.Arrays;

public class Problem_464 {

    int[][] memo;
    boolean flag = false;
    int desiredTotal = 0;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        memo = new int[maxChoosableInteger][maxChoosableInteger];
        for(int[] a : memo){
            Arrays.fill(a,-1);
        }
        this.desiredTotal = desiredTotal;
        memo(0,maxChoosableInteger);
        return flag;
    }


    private int memo(int start,int end){
        if(flag) return 0;
        if(start > end) return 0;
        if(start == end) return start;
        if(memo[start][end] == desiredTotal) flag = true;
        if(memo[start][end] != -1) return memo[start][end];
        int chooseStart = start + Math.min(
                memo(start+2,end),
                memo(start+1,end-1)
        );
        int chooseEnd = end + Math.min(
                memo(start+1,end-1),
                memo(start,end-2)
        );
        return memo[start][end] = Math.max(chooseStart,chooseEnd);
    }
}
