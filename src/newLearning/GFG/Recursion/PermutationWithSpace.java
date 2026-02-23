package newLearning.GFG.Recursion;

import java.util.ArrayList;
import java.util.List;

public class PermutationWithSpace {

    public static void main(String[] args) {
        String input = "ABC";
        String output = String.valueOf(input.charAt(0));
        List<String> result = new ArrayList<>();
        solve(input.substring(1),output,result);
        System.out.println(result);
    }

    ArrayList<String> permutation(String string) {
        // Code Here
        ArrayList<String> list = new ArrayList<>();
        if(!string.isBlank()) solve(string.substring(1), String.valueOf(string.charAt(0)),list);
        return list;
    }

    public static void solve(String input,String output,List<String> result){
        if(input.equals("")){
            result.add(output);
            return;
        }
        solve(input.substring(1),output.concat(String.valueOf(input.charAt(0))),result);
        solve(input.substring(1),output.concat("_"+input.charAt(0)),result);
    }





}
