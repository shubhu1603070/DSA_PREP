package Stack;

import java.util.Stack;

public class ValidParentheses_20 {
    public boolean isValid(String s) {
        Stack<Character> characterStack = new Stack<>();
        boolean flag = false;
        for(Character ch : s.toCharArray()){
            if(ch == '(') characterStack.push(')');
            else if(ch == '[') characterStack.push(']');
            else if(ch == '{') characterStack.push('}');
            else if(characterStack.isEmpty() || !characterStack.pop().equals(ch)) return false;
        }
        return characterStack.isEmpty();
    }
}
