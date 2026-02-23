package Recursion.Externded_IO_OP;

import java.util.ArrayList;
import java.util.List;

public class Permutation_With_Capital_Letters_GFG {

    private void dfs(String initialString,String result,List<String> list){
        if(initialString.isBlank()){
            if(!list.contains(result)) list.add(result);
            return;
        }
        char ch = initialString.charAt(0);
        String res1 = result+(Character.isDigit(ch) ? ch : String.valueOf(ch).toUpperCase());
        String res2 = result+ch;
        dfs(initialString.substring(1),res1,list);
        dfs(initialString.substring(1),res2,list);
    }

    private void dfs(String str){
        List<String> list = new ArrayList<>();
        dfs(str,"",list);
        System.out.println(list);
    }

    public static void main(String[] args) {
        Permutation_With_Capital_Letters_GFG pmcl = new Permutation_With_Capital_Letters_GFG();
        pmcl.dfs("a1b2");
    }

}
