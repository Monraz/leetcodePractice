package may;

import java.util.Stack;

public class MinRemoveToValidParentheses {
 public String minRemoveToMakeValid(String s) {
        /*
        1. traverse from left to right the string chars.
        2. for every ( found, increase a counter by 1, and save the index of the char in a Stack
        3. for every ) found, reduce the counter by 1.
        4. If you find a ) and the counter is at 0, replace it with a space.
        5. If once we finished traversing the string, the counter is greater than zero, remove from the string
        the open parentheses the number of times that the counter is above 0 using the indexes from the stack.
        6. Finally, returned the finished String, removing the spaces that used to be invalid ).

        Note: in step 4 we are replacing the invalid ) with a space to keep the length of the original String
        the same until we remove any extra (. If we deleted the ) rather than replacing them, it might cause
        and IndexOutOfBound in the while loop*/

        StringBuilder sb = new StringBuilder(s);
        int openParenthesesCounter = 0;
        Stack<Integer> openParenthesesStack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i<chars.length; i++) {
            if (chars[i] == '(') {
                openParenthesesCounter++;
                openParenthesesStack.add(i);
            } else if (chars[i] == ')') {
                if (openParenthesesCounter > 0) {
                    openParenthesesCounter--;
                } else {
                    sb.setCharAt(i, ' ');
                }
            }
        }

        while (openParenthesesCounter > 0) {
            sb.deleteCharAt(openParenthesesStack.pop());
            openParenthesesCounter--;
        }
        return sb.toString().replace(" ", "");
    }
}
