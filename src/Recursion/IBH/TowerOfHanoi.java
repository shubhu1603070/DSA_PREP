package Recursion.IBH;

public class TowerOfHanoi {

    static int count = 0;
    public static void solve(int s,int h,int d,int n){
        if(n == 0){
            return;
        }
        count++;
        solve(s,d,h,n-1);
        System.out.println("Moving plate from "+s+" to "+d);
        solve(h,s,d,n-1);
    }

    public static void main(String[] args) {
        solve(0,1,2,3);
        System.out.println("Total count is: "+count);
    }

}
