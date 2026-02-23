package MonotonicStack;

import java.util.Arrays;

public class NextSmallestPalindrome_High_SUBS {

    public String subs(String str){

        char[] ch = new char[str.length()/2];
        for(int i = 0;i<str.length()/2;i++) {
            ch[i] = str.charAt(i);
        }

        int len = ch.length-1;


        //Find the first number where the value starts decreasing
        int lastIndex = len;
        while(lastIndex>=0){
            if(ch[lastIndex] > ch[lastIndex-1]) break;
            lastIndex--;
        }

        if(lastIndex <= 0) return "";

        int f1 = lastIndex-1;

        //Find the first increasing value from this f1 so we can replace it.
        int f2 = len;
        while(f2 >= f1){
            if(ch[f2] > ch[f1]) break;
            f2--;
        }

        char temp = ch[f1];
        ch[f1] = ch[f2];
        ch[f2] = temp;
        StringBuilder reverse = reverse(lastIndex, ch, len);
        String firstHalf = reverse.toString();
        return firstHalf.concat(reverse.reverse().toString());

    }

    private StringBuilder reverse(int start, char[] ch,int end) {
        while(start <= end){
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
        return new StringBuilder(String.valueOf(ch));
    }


}
