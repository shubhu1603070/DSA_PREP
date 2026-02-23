package Recursion.Externded_IO_OP;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PrintNbitbinarynumbershavingmore1sthan0s_GFG {

    private static void dfs(int zeros,int ones,int n,String result,ArrayList<String> list){
        if(n == 0){
            list.add(result);
            return;
        }
        if(ones > zeros){
            dfs(zeros+1,ones,n-1,result+=0,list);
            result = result.substring(0,result.length()-1);
        }
        dfs(zeros,ones+1,n-1,result+=1,list);
        result = result.substring(0,result.length()-1);
    }


    public static void main(String[] args) {
        ArrayList<String> res = new ArrayList<>();
        int n = 3;
        dfs(0,1,n-1,"1",res);
        res = new ArrayList<>(res.stream().sorted(Comparator.reverseOrder()).toList());
        System.out.println(res);
    }

}
