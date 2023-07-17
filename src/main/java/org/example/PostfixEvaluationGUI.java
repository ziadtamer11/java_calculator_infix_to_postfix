package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PostfixEvaluationGUI extends JFrame implements ActionListener {
    private JTextField inputField;
    private JLabel resultLabel;

    public PostfixEvaluationGUI() {
        super("Postfix Evaluation");

        // Set up UI elements
        JLabel messageLabel = new JLabel("Enter a postfix expression:");
        inputField = new JTextField();
        JButton convertButton = new JButton("Evaluate");
        convertButton.addActionListener(this);
        resultLabel = new JLabel();

        // Set up layout
        setLayout(new GridLayout(4, 1));
        add(messageLabel);
        add(inputField);
        add(convertButton);
        add(resultLabel);

        // Set up window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String input = inputField.getText();
        String result = String.valueOf(PostfixEvaluation.evaluatePostfix(input));
        if (result == null) {
            resultLabel.setText("Invalid expression");
        } else {
            resultLabel.setText("Result: " + result);
        }
    }

    public static void main(String[] args) {
        new PostfixEvaluationGUI();
    }
}