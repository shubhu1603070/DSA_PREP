package newLearning.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Problem_132 {

    public static void main(String[] args) {
        Problem_132 obj = new Problem_132();
        obj.minCut("aab");
        obj.minCut("aaa");
        obj.minCut("a");
        obj.minCut("leet");
    }

    boolean[][] it;
    int[] dp;
    public int minCut(String s) {
        it  = new boolean[2001][2001];
        dp = new int[2001];
        Arrays.fill(dp,-1);
        for(boolean[] d : it) Arrays.fill(d,false);
        int ans = Integer.MAX_VALUE;
        ans = dfs(s,0,s.length()-1);
        System.out.println("ans: "+ans);
        return ans;
    }

    private int dfs(String s,int start,int end){
        if(start >= end || isPalindrome_(s,start,end)) return 0;
        if(dp[start]!=-1) return dp[start];
        int min = Integer.MAX_VALUE;
        for(int i = start+1; i <= end; i++){
            if(isPalindrome_(s,start,i-1)){
                min =  Math.min(min,dfs(s,i,end));
            }
        }
        return dp[start] = min+1;
    }

    private boolean isPalindrome_(String str,int low,int high){
        if(low >= high || it[low][high]) return true;
        if(str.charAt(low)!=str.charAt(high)) return false;
        return it[low][high] = isPalindrome_(str,low+1,high-1);
    }

    private void palindromePartition(String s,int start,int end,List<String> list,List<List<String>> result){
        if(start >= end) return;
        for(int i = start;i < end;i++){
            if(palin(s.substring(start,i+1))){
                list.add(s.substring(start,i+1));
                palindromePartition(s,i+1,end,list,result);
                result.add(new ArrayList<>(list));
                list.removeLast();
            }
        }
    }

    private boolean palin(String s){
        int i = 0, j = s.length()-1;
        while(i < j){
            if(s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }


    private int dfs_(String s,int start,int end){
        if(start >= end || palin_(s)) return 0;
        int max = Integer.MAX_VALUE;
        for(int i = start;i < end;i++){
            int tempRes = 1 + dfs_(s,start,i) + dfs_(s,i+1,end);
            max = Math.min(max,tempRes);
        }
        return max;
    }

    private boolean palin_(String str){
        int start = 0,  end = str.length()-1;
        while(start < end){
            if(str.charAt(start++) != str.charAt(end--)) return false;
        }
        return true;
    }



}
