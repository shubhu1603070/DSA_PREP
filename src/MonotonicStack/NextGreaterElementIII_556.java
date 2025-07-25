package MonotonicStack;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NextGreaterElementIII_556 {

    public int nextGreaterElement(int n) {

        char[] ch = (String.valueOf(n)).toCharArray();

        int decreasingFromEnd = ch.length-1;
        while(decreasingFromEnd>0){
            if(ch[decreasingFromEnd-1] < ch[decreasingFromEnd]) break;
            decreasingFromEnd--;
        }
        if(decreasingFromEnd == 0) return -1;

        int secondDecreasingFromEnd = ch.length-1;

        while (secondDecreasingFromEnd>=decreasingFromEnd){
            if(ch[secondDecreasingFromEnd-1] < ch[secondDecreasingFromEnd]) break;
            secondDecreasingFromEnd--;
        }

        if(secondDecreasingFromEnd == decreasingFromEnd) return -1;

        char temp = ch[decreasingFromEnd];
        ch[decreasingFromEnd] = ch[secondDecreasingFromEnd];
        ch[secondDecreasingFromEnd] = temp;

        reverse(decreasingFromEnd+1,ch);
        long ans = Long.parseLong(new String(ch));
        return ans <= Integer.MAX_VALUE ? ((int) ans) : -1;
    }

    private void reverse(int start, char[] ch) {
        int end = ch.length-1;
        while(start<=end){
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
    }

}
