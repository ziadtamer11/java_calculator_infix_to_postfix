package org.example;

import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Main {
    InfixToPostfix infixToPostfix = new InfixToPostfix();
    PostfixEvaluation postfixEvaluation = new PostfixEvaluation();

    public static void display() {
        System.out.println("\n" +
                "░██╗░░░░░░░██╗███████╗██╗░░░░░░█████╗░░█████╗░███╗░░░███╗███████╗  ████████╗░█████╗░  ███╗░░░███╗██╗░░░██╗\n" +
                "░██║░░██╗░░██║██╔════╝██║░░░░░██╔══██╗██╔══██╗████╗░████║██╔════╝  ╚══██╔══╝██╔══██╗  ████╗░████║╚██╗░██╔╝\n" +
                "░╚██╗████╗██╔╝█████╗░░██║░░░░░██║░░╚═╝██║░░██║██╔████╔██║█████╗░░  ░░░██║░░░██║░░██║  ██╔████╔██║░╚████╔╝░\n" +
                "░░████╔═████║░██╔══╝░░██║░░░░░██║░░██╗██║░░██║██║╚██╔╝██║██╔══╝░░  ░░░██║░░░██║░░██║  ██║╚██╔╝██║░░╚██╔╝░░\n" +
                "░░╚██╔╝░╚██╔╝░███████╗███████╗╚█████╔╝╚█████╔╝██║░╚═╝░██║███████╗  ░░░██║░░░╚█████╔╝  ██║░╚═╝░██║░░░██║░░░\n" +
                "░░░╚═╝░░░╚═╝░░╚══════╝╚══════╝░╚════╝░░╚════╝░╚═╝░░░░░╚═╝╚══════╝  ░░░╚═╝░░░░╚════╝░  ╚═╝░░░░░╚═╝░░░╚═╝░░░\n" +
                "\n" +
                "               ██████╗░░██████╗  ██████╗░██████╗░░█████╗░░░░░░██╗███████╗░█████╗░████████╗\n" +
                "               ██╔══██╗██╔════╝  ██╔══██╗██╔══██╗██╔══██╗░░░░░██║██╔════╝██╔══██╗╚══██╔══╝\n" +
                "               ██║░░██║╚█████╗░  ██████╔╝██████╔╝██║░░██║░░░░░██║█████╗░░██║░░╚═╝░░░██║░░░\n" +
                "               ██║░░██║░╚═══██╗  ██╔═══╝░██╔══██╗██║░░██║██╗░░██║██╔══╝░░██║░░██╗░░░██║░░░\n" +
                "               ██████╔╝██████╔╝  ██║░░░░░██║░░██║╚█████╔╝╚█████╔╝███████╗╚█████╔╝░░░██║░░░\n" +
                "               ╚═════╝░╚═════╝░  ╚═╝░░░░░╚═╝░░╚═╝░╚════╝░░╚════╝░╚══════╝░╚════╝░░░░╚═╝░░░");
        System.out.println(" ");
        System.out.println("1. Convert Infix To Postfix");
        System.out.println("2. Postfix Evaluation");
        System.out.println("Enter your choice: ");
    }


    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        display();
        String input = sc.nextLine();

        switch (input) {
            case "1":
                System.out.println("Enter infix expression: ");
                input = sc.nextLine();
                if (InfixToPostfix.isInfixExpression(input)) {
                    String result = InfixToPostfix.infixToPostfix(input);
                    System.out.println("Postfix expression: " + result);
                } else if (PostfixEvaluation.isPostfixExpression(input)) {
                    System.err.println("error: the input is postfix expression");
                } else {
                    System.err.println("Invalid expression");
                }

                break;
            case "2":
                System.out.println("Enter postfix expression: ");
                input = sc.nextLine();

                PostfixEvaluation.isPostfixExpression(input);
                if (PostfixEvaluation.isPostfixExpression(input) == true) {
                    int result = (int) PostfixEvaluation.evaluatePostfix(input);
                    System.out.println("Result: " + result);
                } else if (InfixToPostfix.isInfixExpression(input) == true) {
                    System.err.println("error: the input is infix expression");
                } else {
                    System.err.println("Invalid expression");

                }
                break;

            default:
                System.err.println("Invalid choice");
        }

        sleep(1000);

        System.out.println(" ");
        System.out.println("press Enter to continue...");
        System.out.println("press 0 to exit...");
        String a = sc.nextLine();
        if (a.equals("0")) {
            System.out.println("Exiting...");
            System.exit(0);
        }
        // re-run the main method
        main(args);

        //infix
        // 2 + 3 * 4
        // 2 + 3 * 4 + 5
        // 2 + 3 * 4 + 5 / 6
        // 2 + 3 * 4 + 5 / 6 - 7
        // 2 + 3 * 4 + 5 / 6 - 7 * 8
        // 2 + 3 * 4 + 5 / 6 - 7 * 8 / 9
        // 2 + 3 * 4 + 5 / 6 - 7 * 8 / 9 + 10

        //postfix
        // 2 3 4 * +
        // 2 3 4 * + 5 +
        // 2 3 4 * + 5 6 / +
        // 2 3 4 * + 5 6 / + 7 -
        // 2 3 4 * + 5 6 / + 7 8 * -
        // 2 3 4 * + 5 6 / + 7 8 * 9 / -


    }
}