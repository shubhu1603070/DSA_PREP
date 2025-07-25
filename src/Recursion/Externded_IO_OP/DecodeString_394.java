package Recursion.Externded_IO_OP;

public class DecodeString_394 {


    private String dfs(String actualString,int number,String result,String currentRunningString){
        System.out.println("Actual String : "+actualString+" Result : "+result+" currentRunningString: "+currentRunningString+" number : "+number);
        char ch = actualString.charAt(0);
        if(Character.isDigit(ch)){
            number = number * 10 + Integer.parseInt(actualString.substring(0,1));
        }else if(ch == '['){
            String temp = dfs(actualString.substring(1),number,result,currentRunningString+ch);
            String tempResult = createResult("", currentRunningString, number);
            result+=tempResult;
        }else if(ch == ']'){
            return result;
        }
        return dfs(actualString.substring(1),number,result,currentRunningString+ch);
    }

    private String createResult(String result,String currentRunningString, int number) {
        if(number == 0) return result;
        result+=currentRunningString;
        return createResult(result,currentRunningString,number-1);
    }

    public String decodeString(String s) {
        String result = "";
        dfs(s,0,result,"");
        return result;
    }


    private int dfs(int step,int n,boolean left,int result){
        if(n > 1){
            if(left || (n&1) == 1){
                result+=step;
            }
            return dfs(step*2,n/2,!left,result);
        }
        return result;
    }

    public int lastRemaining(int n) {
        return dfs(1,n,true,1);
    }
}
