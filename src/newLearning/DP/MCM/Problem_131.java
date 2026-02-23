package newLearning.DP.MCM;

import java.util.ArrayList;
import java.util.List;

public class Problem_131 {

    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        solve(s,0,new ArrayList<>());
        return res;
    }

    private void solve(String s, int i,List<String> list) {
        if(i >= s.length()){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int index = i;index<s.length();index++){
            if(isPalindrome(s.substring(i,index+1))){
                list.add(s.substring(i,index+1));
                solve(s,index+1,list);
                list.removeLast();
            }
        }
    }

    private boolean isPalindrome(String s){
        int i = 0,j = s.length()-1;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
