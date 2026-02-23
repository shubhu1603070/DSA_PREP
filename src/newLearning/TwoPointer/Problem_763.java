package newLearning.TwoPointer;

import java.util.ArrayList;
import java.util.List;

public class Problem_763 {

    public static void main(String[] args) {

        String str = "ababcbacadefegdehijhklij";

        Problem_763 obj = new Problem_763();
//        System.out.println(obj.partitionLabels("ababcbacadefegdehijhklij"));
//        System.out.println(obj.partitionLabels("eccbbbbdec"));
//        System.out.println(obj.partitionLabels("a"));


        obj.test("ababcbacadefegdehijhklij");
        obj.test("eccbbbbdec");
        obj.test("a");

    }

    public List<Integer> partitionLabels(String s) {

        List<Integer> result = new ArrayList<>();

        int i = 0;
        int n = s.length();
        int j = 0;
        int k = 0;
        while(i < n && j < n){
            j = s.lastIndexOf(s.charAt(i)) + 1;
            while(j < n && i < j){
                int temp = s.lastIndexOf(s.charAt(i))+1;
                j = Math.max(j, temp);
                i++;
            }
            result.add(s.substring(k,j).length());
            k = i;
        }
        return result;
    }
    
    
    private void test(String s){
        List<Integer> result = new ArrayList<>();
        int[] indexes = new int[26];
        int n = s.length();
        for(int i = 0; i < n; i++){
            indexes[s.charAt(i)-'a'] = i;
        }
        
        int temp = 0;
        int lastIndex = 0;
        for(int i = 0;i<n;i++){
            lastIndex = Math.max(lastIndex,indexes[s.charAt(i)-'a']);
            if(i == lastIndex){
                result.add(i - temp + 1);
                temp = i + 1;
            }
        }

        System.out.println(result);
        
    }

}
