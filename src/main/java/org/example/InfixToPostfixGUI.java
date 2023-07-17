package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfixToPostfixGUI extends JFrame implements ActionListener {
    private JTextField inputField;
    private JLabel resultLabel;

    public InfixToPostfixGUI() {
        super("Infix to Postfix Converter");

        // Set up UI elements
        JLabel messageLabel = new JLabel("Enter an infix expression:");
        inputField = new JTextField();
        JButton convertButton = new JButton("Convert");
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
        String postfix = InfixToPostfix.infixToPostfix(input);
        if (postfix == null) {
            resultLabel.setText("Invalid expression");
        } else {
            resultLabel.setText("Postfix: " + postfix);
        }
    }

    public static void main(String[] args) {
        new InfixToPostfixGUI();
    }
}
