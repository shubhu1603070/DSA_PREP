package Recursion.Externded_IO_OP;

import java.util.ArrayList;
import java.util.List;

public class Valid_Paranthesis_GFG {


    private List<String> generateParanthesis(int open,int close,String res,List<String> list){
        if(open == 0 && close == 0) {
            list.add(res);
            return list;
        }
        if(open >= 0) generateParanthesis(open-1,close,res+"(",list);
        if(close > open) generateParanthesis(open,close-1,res+")",list);
        return list;
    }

    private void dfs(int n){
        List<String> res = new ArrayList<>();
        generateParanthesis(n,n,"",res);
        System.out.println(res);
    }

    public static void main(String[] args) {
        Valid_Paranthesis_GFG validParanthesis = new Valid_Paranthesis_GFG();
        validParanthesis.dfs(3);
    }

}
