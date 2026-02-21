package newLearning.DP.knapsack;

public class Problem_650 {


    public int minSteps(int n) {
        if(n < 0) return 0;
        return solve(n,1);
        //paste
        //copy

    }

    /*
        A
     */
    private int solve(int n,int chars){
        if(n < 0) return 0;
        int copy = solve(n-1,2*chars);
        int paste = chars + solve(n-1,chars);
        return Math.max(copy,paste);
    }

}
