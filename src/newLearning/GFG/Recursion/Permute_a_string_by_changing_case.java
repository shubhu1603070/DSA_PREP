package newLearning.GFG.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permute_a_string_by_changing_case {

    public static void main(String[] args) {
        String input = "ABC";
        String output = "";
        List<String> result = new ArrayList<>();
        solve(input,output,result);
        Collections.sort(result);
        System.out.println(result);
    }

    private static void solve(String ip, String op, List<String> res){
        if(ip.isBlank()){
            res.add(op);
            return;
        }
        String op1 = String.valueOf(ip.charAt(0));
        solve(ip.substring(1),op.concat(op1.toUpperCase()),res);
        solve(ip.substring(1),op.concat(op1.toLowerCase()),res);
    }

}
