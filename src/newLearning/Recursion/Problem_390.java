package newLearning.Recursion;

public class Problem_390 {

    public int lastRemaining(int n) {
        return 0;
    }

    private int solve(int start,int end,boolean flag){
        if(start == end) return start;
        if(flag){
            solve(start,end,false);
        }else{
            solve(end,start,true);
        }
        return 0;
    }

}
