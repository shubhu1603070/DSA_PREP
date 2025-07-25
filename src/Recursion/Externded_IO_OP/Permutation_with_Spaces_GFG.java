package Recursion.Externded_IO_OP;

import java.util.ArrayList;

public class Permutation_with_Spaces_GFG {

    public static ArrayList<String> pws(String str, String result, ArrayList<String> list){
        if(str.length() == 0){
            if(!list.contains(result)) list.add(result);
            return list;
        }
        String r1 = result+" "+str.charAt(0);
        String r2 = result+str.charAt(0);
        pws(str.substring(1),r1,list);
        pws(str.substring(1),r2,list);
        return list;
    }

    private static ArrayList<String> dfs(String string){
        ArrayList<String> list = new ArrayList<>();
        return string.isBlank() ? list : pws(string.substring(1),""+string.charAt(0)+"",list);
    }

    public static void main(String[] args) {
        String string = "ABC";
        ArrayList<String> dfs = dfs(string);
        System.out.println(dfs);
    }

}
