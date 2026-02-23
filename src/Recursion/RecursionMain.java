package Recursion;

import Recursion.Externded_IO_OP.DifferentWaystoAddParentheses_241;

import java.util.List;

public class RecursionMain {

    public static void main(String[] args) {
        DifferentWaystoAddParentheses_241 dfs = new DifferentWaystoAddParentheses_241();
        List<Integer> list = dfs.diffWaysToCompute("2*3-4*5");
        System.out.println(list);

    }

}
