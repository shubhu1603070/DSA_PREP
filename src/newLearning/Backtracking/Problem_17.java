package newLearning.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Problem_17 {


    public static void main(String[] args) {
        Problem_17 p = new Problem_17();
        p.letterCombinations("239");
    }

    String[] arr = new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        dfs(0,digits.length(),digits,res,new StringBuilder());
        System.out.println(res);
        return res;
    }


    private StringBuilder dfs(int start,int n,String str,List<String> res,StringBuilder strb){
        if(start >= n) return new StringBuilder();
        int val = str.charAt(start)-'0';
        for(char c : arr[val-2].toCharArray()){
            strb.append(c).append(dfs(start+1,n,str,res,strb));
            if(strb.length() == str.length()) res.add(strb.toString());
            strb.deleteCharAt(strb.length()-1);
        }
        return new StringBuilder();
    }

}
