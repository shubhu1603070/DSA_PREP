package Recursion.Externded_IO_OP;

public class EliminationGame_390 {

    //it's a joseph problem
    public int lastRemaining(int n) {
        return n == 1 ? 1 : 2 * (1+n/2 - lastRemaining(n/2));
    }

}
