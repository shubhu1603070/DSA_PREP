package newLearning.DP.LIS;

import java.util.Arrays;
import java.util.List;

public class Problem_646 {


    public static void main(String[] args) {
        Problem_646 p = new Problem_646();
        System.out.println(p.findLongestChain(new int[][]{{1, 2}, {2, 3}, {3, 4}}));
        System.out.println(p.findLongestChain(new int[][]{{1,2},{4,2},{7,8},{4,5}}));
    }

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(o1,o2)->{
            if(o1[0] != o2[0]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });
        for(int[] a : pairs){
            System.out.println(a[0] + " " + a[1]);
        }
        int p1,p2;
        p1 = -1;
        p2 = -1;
        int res = 0;
        for(int[]  a : pairs){
            if(p1 == -1 && p2 == -1){
                p1 = a[0];
                p2 = a[1];
                res++;
            }else if(p2 < a[0]){
                p1 = a[0];
                p2 = a[1];
                res++;
            }
        }
        return res;
    }

}
