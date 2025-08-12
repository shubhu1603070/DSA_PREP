package POTD;

import java.util.Arrays;

public class Ways_To_Express_An_Integer_As_Sum_Of_Powers_2787 {

    public int numberOfWays(int n, int x) {
        for(int[] a : memo){
            Arrays.fill(a,-1);
        }
        return dfs(n,1,x);
    }

    private int mod = (int) (1e9+7);
    int[][] memo = new int[301][301];

    private int dfs(int n,int index,int x){
        int value = ((int) Math.pow(index, x));
        if(0 == n) return 1;
        if(n < 0 || value > n) return 0;
        if(memo[n][index] != -1) return memo[n][index];
        if(n  >= (n - value)){
            return memo[n][index] = (dfs(n-value,index+1,x) % mod + dfs(n,index+1,x) % mod)%mod;
        }
        return memo[n][index] = dfs(n,index+1,x)%mod;
    }

}
