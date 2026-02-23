package newLearning.GFG.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class PrintNbitbinarynumbershavingmore1sthan0s {


    ArrayList<String> res;

    public static void main(String[] args) {
        PrintNbitbinarynumbershavingmore1sthan0s p = new PrintNbitbinarynumbershavingmore1sthan0s();
        p.NBitBinary(1);
        System.out.println(p.res);
    }

    ArrayList<String> NBitBinary(int N) {
        // code here
        res = new ArrayList<>();
        if(N > 0) solve(N,1,0,"1");
        return res;

    }

    private void solve(int n,int numberOfOnes,int numberOfZeros,String op){
        if(numberOfZeros > numberOfOnes || numberOfOnes > n){
            return;
        }
        if(op.length() == n){
            res.add(op);
            return;
        }
        solve(n,numberOfOnes+1,numberOfZeros,op.concat("1"));
        solve(n,numberOfOnes,numberOfZeros+1,op.concat("0"));
    }


}
