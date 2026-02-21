package newLearning.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_22 {

    List<String> res;

    public static void main(String[] args) {
        Problem_22 problem22 = new Problem_22();
        System.out.println(problem22.generateParenthesis(0));
    }

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        if(n > 0) solve(n,"(",1,0);
        return res;
    }

    private void solve(int n,String opt,int o,int c){
        if(c > o || o > n) return;
        if(c == n && o == n){
            res.add(opt);
            return;
        }
        solve(n,opt.concat("("),o+1,c);
        solve(n,opt.concat(")"),o,c+1);
    }

}
