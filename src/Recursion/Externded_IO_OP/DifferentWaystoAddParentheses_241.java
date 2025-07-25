package Recursion.Externded_IO_OP;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaystoAddParentheses_241 {

    public List<Integer> diffWaysToCompute(String expression) {
        return dfs(expression,new ArrayList<>());
    }
    private List<Integer> dfs(String expression, List<Integer> res) {
        for (int index = 0; index < expression.length(); index++) {
            char ch = expression.charAt(index);
            if(ch == '+' || ch == '-' || ch == '*'){
                List<Integer> left = dfs(expression.substring(0,index),new ArrayList<>());
                List<Integer> right = dfs(expression.substring(index+1),new ArrayList<>());
                for(int l : left){
                    for (int r : right) {
                        if(ch == '+') res.add(l+r);
                        else if(ch == '-') res.add(l-r);
                        else res.add(l*r);
                    }
                }
            }
        }
        if(res.size() == 0) res.add(Integer.parseInt(expression));
        return res;
    }

}
