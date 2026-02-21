package newLearning.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem_241 {

    List<Integer> res = new ArrayList<>();
    List<Character> check;

    public List<Integer> diffWaysToCompute(String expression) {
        check = Arrays.asList('+','-','*');
        solve(expression);
        return res;
    }

    private List<Integer> solve(String exp){
        for(int idx = 0;idx < exp.length();idx++) {
            if (check.contains(exp.charAt(idx))) {
                List<Integer> left = solve(exp.substring(0, idx));
                List<Integer> right = solve(exp.substring(idx));
                for (int l : left)
                    for (int r : right) {
                        if (exp.charAt(idx) == '+') res.add(l + r);
                        else if (exp.charAt(idx) == '-') res.add(l - r);
                        else res.add(l * r);
                    }
            }
        }
        if(res.size() == 0) res.add(Integer.parseInt(exp));
        return res;
    }

}
