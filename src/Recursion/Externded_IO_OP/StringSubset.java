package Recursion.Externded_IO_OP;

public class StringSubset {

    static String str = "123";

    public static void printAllSubsets(String str,int currentIndex,String result){
        if(currentIndex == str.length()){
            System.out.println("["+result+"]");
            return;
        }
        printAllSubsets(str,currentIndex+1,result);
        printAllSubsets(str,currentIndex+1,result+str.charAt(currentIndex));
    }

    public static void main(String[] args) {
        printAllSubsets(str,0,"");
    }


}
