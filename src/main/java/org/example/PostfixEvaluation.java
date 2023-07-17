package org.example;

import java.util.Scanner;

public class PostfixEvaluation {
    //check if the expression is postfix


    public static boolean isPostfixExpression(String input) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isWhitespace(c)) {
                continue;
            } else if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else if (c == '+') {
                if (stack.size() < 2) {
                    return false;
                }
                int operand2 = (int) stack.pop();
                int operand1 = (int) stack.pop();
                stack.push(operand1 + operand2);
            } else if (c == '-') {
                if (stack.size() < 2) {
                    return false;
                }
                int operand2 = (int) stack.pop();
                int operand1 = (int) stack.pop();
                stack.push(operand1 - operand2);
            } else if (c == '*') {
                if (stack.size() < 2) {
                    return false;
                }
                int operand2 = (int) stack.pop();
                int operand1 = (int) stack.pop();
                stack.push(operand1 * operand2);
            } else if (c == '/') {
                if (stack.size() < 2) {
                    return false;
                }
                int operand2 = (int) stack.pop();
                int operand1 = (int) stack.pop();
                stack.push(operand1 / operand2);
            } else {
                // invalid character
                return false;
            }
        }
        return stack.size() == 1;
    }

    //method to check if the character is an operator
    public static boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/' || c == '^');
    }

    //method to check if the character is an operand
    public static boolean isOperand(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    //method to evaluate postfix expression
    public static double evaluatePostfix(String postfix) {
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);

            if (Character.isWhitespace(c)) {
                continue; // skip over whitespace characters
            } else if (Character.isDigit(c)) {
                try {
                    stack.push(Double.parseDouble(String.valueOf(c)));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid character: " + c);
                    return -1;
                }
            } else if (isOperator(c)) {
                double operand2 = (double) stack.pop();
                double operand1 = (double) stack.pop();
                double result = performOperation(c, operand1, operand2);
                stack.push(result);
            } else {
                return -1;
            }
        }
        return (double) stack.pop();
    }


    //method to perform operation
    private static double performOperation(char c, double operand1, double operand2) {
        switch (c) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
            case '^':
                return Math.pow(operand1, operand2);
            case ' ':
                return 0;
        }
        return 0;
    }
}

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter a postfix expression: ");
//        String input = scanner.nextLine();
//        isPostfixExpression(input);
//        String postfix1 = isPostfixExpression(input) ? "is" : "is not";
//        System.out.println("The expression " + postfix1 + " postfix");
//    }
//    public static double evaluatePostfix(String postfix) {
//        Stack<Double> stack = new Stack<>();
//
//        for (int i = 0; i < postfix.length(); i++) {
//            char c = postfix.charAt(i);
//
//            if (Character.isDigit(c)) {
//                try {
//                    stack.push(Double.parseDouble(String.valueOf(c)));
//                } catch (NumberFormatException e) {
//                    System.out.println("Invalid character: " + c);
//                    return -1;
//                }
//            } else if (isOperator(c)) {
//                double operand2 = (double) stack.pop();
//                double operand1 = (double) stack.pop();
//                double result = performOperation(c, operand1, operand2);
//                stack.push(result);
//            } else {
//                return -1;
//            }
//        }
//        return (double) stack.pop();
//    }

