package may;

import java.util.Stack;

public class IsSubsequenceString {
    public static boolean isSubsequence(String s, String t) {
        Stack<Character> subsequenceStack = new Stack<>();
        char[] sCharArray = s.toCharArray();
        for (int i = sCharArray.length - 1; i >= 0; i--) {
            subsequenceStack.add(sCharArray[i]);
        }

        char[] tCharArray = t.toCharArray();
        char sCharacter = subsequenceStack.pop();
        for (char tCharacter : tCharArray) {
            if (sCharacter == tCharacter && !subsequenceStack.isEmpty()) {
                sCharacter = subsequenceStack.pop();
            }
        }

        return subsequenceStack.isEmpty();
    }

    public static void main(String[] args) {
        // Initializing a 2D array that represents an apartment building
        String s1 = "abc";
        String s2 = "ahbgdc";

        boolean isSubsequence = isSubsequence(s1, s2);
        System.out.println(isSubsequence ? "Is subsequence!" : "Not a subsequence");
    }
}