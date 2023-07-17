package org.example;


import java.util.Scanner;

public class InfixToPostfix {
    public static boolean isInfixExpression(String input) {

        int numOperators = 0;
        int numOperands = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isWhitespace(c)) {
                continue;
            } else if (isOperand(c)) {
                numOperands++;
            } else if (isOperator(c)) {
                numOperators++;
            } else if (isLeftBracket(c)) {
                stack.push(c);
            } else if (isRightBracket(c)) {
                if (stack.isEmpty() || !isLeftBracket((Character) stack.peek())) {
                    return false;
                }
                stack.pop();
            }
        }
        return numOperators > 0 && numOperands > 0 && stack.isEmpty() && !isOperator(input.charAt(input.length() - 1));
    }


    public static int precedence(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        } else if (operator == '^') {
            return 3;
        }
        return -1;
    }

    // method to check if the character is an operator
    public static boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/' || c == '^');
    }

    //method to check if the character is an operand
    public static boolean isOperand(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }


    //method to check if the character is a left parenthesis
    public static boolean isLeftBracket(char c) {
        return (c == '(');
    }

    //method to check if the character is a right parenthesis

    public static boolean isRightBracket(char c) {
        return (c == ')');
    }

    //method to convert infix to postfix
    public static String infixToPostfix(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        boolean decimal = false;

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if (Character.isWhitespace(c)) {
                continue;
            } else if (isOperand(c)) {
                postfix.append(c);
                if (c == '.') {
                    decimal = true;
                }
            } else if (isOperator(c)) {
                while (!stack.isEmpty() && !isLeftBracket((Character) stack.peek()) && precedence(c) <= precedence((Character) stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
                decimal = false;
            } else if (isLeftBracket(c)) {
                stack.push(c);
                decimal = false;
            } else if (isRightBracket(c)) {
                while (!stack.isEmpty() && !isLeftBracket((Character) stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.pop();
                decimal = false;
            } else {
                System.err.println("Invalid character");
                return null;
            }
        }

        while (!stack.isEmpty()) {
            if (isLeftBracket((Character) stack.peek())) {
                System.err.println("Error: Mismatched parentheses");
                return null;
            } else {
                postfix.append(stack.pop());
            }
        }
        return postfix.toString();
    }
}
    //    public static String infixToPostfix(String infix) {
//        Stack<Character> stack = new Stack<>();
//        String postfix = "";
//
//        for (int i = 0; i < infix.length(); i++) {
//            char c = infix.charAt(i);
//
//            if (isOperand(c)) {
//                postfix += c;
//            } else if (isOperator(c)) {
//                while (!stack.isEmpty() && !isLeftPracket((Character) stack.peek()) && precedence(c) <= precedence((Character) stack.peek())) {
//                    postfix += stack.pop();
//                }
//                stack.push(c);
//            } else if (isLeftPracket(c)) {
//                stack.push(c);
//            } else if (isRightPracket(c)) {
//                while (!stack.isEmpty() && !isLeftPracket((Character) stack.peek())) {
//                    postfix += stack.pop();
//                }
//                if (stack.isEmpty()) {
//                    System.err.println("Error: Mismatched parentheses");
//                    return null;
//                } else {
//                    stack.pop();
//                }
//            } else {
//                return null;
//            }
//        }
//        while (!stack.isEmpty()) {
//            if (isLeftPracket((Character) stack.peek())) {
//                System.out.println("Error: Mismatched parentheses");
//                return null;
//            } else {
//                postfix = stack.pop() + postfix;
//            }
//        }
//        return postfix;
//    }
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter infix expression: ");
//        String infix = scanner.nextLine();
//        isInfixExpression(infix);
//        String infix1 = String.valueOf(isInfixExpression(infix));
//        System.out.println("is expression: " + infix1);
//    }



