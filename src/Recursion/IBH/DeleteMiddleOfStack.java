package Recursion.IBH;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DeleteMiddleOfStack {


    public static void deleteOfStackInMiddle(Stack<Integer> stack,int index){
        if(stack.size() == index){
            stack.pop();
            return;
        }
        int element = stack.pop();
        deleteOfStackInMiddle(stack,index);
        stack.push(element);
    }


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.addAll(List.of(1,2,3,4,5,6));
        deleteOfStackInMiddle(stack,3);
        System.out.println(stack);
    }


}
