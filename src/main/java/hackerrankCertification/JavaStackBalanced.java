package hackerrankCertification;

import java.util.Stack;

public class JavaStackBalanced {

    public static void main(String[] args) {

        char[] charArray = new char[]{'{', '[', '(', ')', ']', '}'};
        Stack<Character> stack = new Stack<Character>();
        boolean balanced = balancedArray(charArray, stack);
        System.out.println(" Is Balanced -->" + balanced);


    }

    private static boolean balancedArray(char[] charArray, Stack<Character> stack) {
        boolean balanced = false;
        for (char sign : charArray) {
            if (sign == '{' || sign == '[' || sign == '(') {
                stack.push(sign);
            } else {
                char top = stack.pop();
                if ((top == '(' && sign != ')') || (top == '{' && sign != '}') || (top == '[' && sign != ']')) {
                    balanced = false;
                } else {
                    balanced = true;
                }
            }
        }
        return balanced;
    }

}
