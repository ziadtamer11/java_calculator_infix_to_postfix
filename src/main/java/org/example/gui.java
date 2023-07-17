package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gui extends JFrame implements ActionListener {
    private JTextField inputField;
    private JLabel postfixResultLabel;
    private JLabel evaluationResultLabel;
    private JButton postfixConvertButton;
    private JButton infixConvertButton;

    public gui() {
        super("Expression Converter");

        // Set up UI elements for infix to postfix conversion
        JLabel infixMessageLabel = new JLabel("Enter an infix expression:");
        inputField = new JTextField();
        infixConvertButton = new JButton("Convert");
        infixConvertButton.addActionListener(this);
        postfixResultLabel = new JLabel();

        // Set up UI elements for postfix evaluation
        JLabel postfixMessageLabel = new JLabel("Enter a postfix expression:");
        postfixConvertButton = new JButton("Evaluate");
        postfixConvertButton.addActionListener(this);
        evaluationResultLabel = new JLabel();

        // Set up layout
        setLayout(new GridLayout(6, 1));
        add(infixMessageLabel);
        add(inputField);
        add(infixConvertButton);
        add(postfixMessageLabel);
        add(postfixConvertButton);
        add(postfixResultLabel);
        add(evaluationResultLabel);

        // Set up window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String input = inputField.getText();
        String postfix = InfixToPostfix.infixToPostfix(input);
        if (e.getSource() == postfixConvertButton) {
            String result = String.valueOf(PostfixEvaluation.evaluatePostfix(input));
            if (result == null) {
                evaluationResultLabel.setText("Invalid expression");
            } else {
                evaluationResultLabel.setText("Result: " + result);
            }
        } else if (e.getSource() == infixConvertButton) {
            if (postfix == null) {
                postfixResultLabel.setText("Invalid expression");
            } else {
                postfixResultLabel.setText("Postfix: " + postfix);
            }
        }
    }

    public static void main(String[] args) {
        new gui();
    }
}
