/// Task 61 (the classic stack use case — genuinely worth understanding, not just solving): Check if a string of brackets is 
// "balanced" — every opening bracket has a matching closing bracket in the correct order. Test with "({[]})" (balanced → true) 
// and "({[})]" (not balanced → false — note the crossing mismatch). Think about why a stack is the natural tool here: when you 
// see an opening bracket, push it. When you see a closing bracket, it should match whatever's currently on top of the stack 
// (the most recently opened, still-unclosed bracket) — if it doesn't match, or the stack's empty when you expect something, it's 
// unbalanced. Use Java's built-in Stack<Character> for this one.

import java.util.Stack;

class Task61_ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isBalanced("({[]})"));
        System.out.println(isBalanced("({[})]"));

    }

    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);

            if (current == '(' || current == '{' || current == '[') {
                stack.push(current);
            } else if (current == ')' || current == '}' || current == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.peek();

                if (current == ')' && top != '(') {
                    return false;
                }
                if (current == '}' && top != '{') {
                    return false;
                }
                if (current == ']' && top != '[') {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();

    }

}
