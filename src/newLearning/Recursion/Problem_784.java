package newLearning.Recursion;

import java.util.ArrayList;
import java.util.List;

public class Problem_784 {

    List<String> result = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        solve(s.toCharArray(),0,s.length());
        return result;
    }

    //"a1b2"

    private void solve(char[] arr,int index,int size){
        System.out.println(new String(arr));
        if(index == size) {
            String str = new String(arr);
            if(!result.contains(str))
                result.add(str);
            return;
        }
        if(!Character.isDigit(arr[index])){
            arr[index] = Character.toUpperCase(arr[index]);
            solve(arr,index+1,size);
            arr[index] = Character.toLowerCase(arr[index]);
            solve(arr,index+1,size);
        }
    }

    private static void solve(String ip,String op,List<String> res){
        if(ip.isBlank()){
            res.add(op);
            return;
        }
        if(!Character.isDigit(ip.charAt(0))){
            solve(ip.substring(1),op.concat(String.valueOf(ip.charAt(0)).toUpperCase()),res);
            solve(ip.substring(1),op.concat(String.valueOf(ip.charAt(0)).toLowerCase()),res);
        }else{
            solve(ip.substring(1),op.concat(String.valueOf(ip.charAt(0))),res);
        }
    }

}
