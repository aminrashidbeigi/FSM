package com.statemachine.gui;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

public class UserInput extends JFrame {



    static boolean isSubmitted = false;
    private String userWord = "";
    static int sizeOfArray;
    private JTextField userInput = new JTextField(10);
    JButton submit = new JButton("Submit");
    private JLabel jLabel = new JLabel("Enter the number of rows and cols of table: ");

    public UserInput() {
        super("User Input");
        setSize(300, 180);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        jLabel.setBounds(10,10,400,30);
        userInput.setBounds(115,40,50,30);
        submit.setBounds(100,80,80,30);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitAction();
                dispose();
                new DynamicForm();
            }
        });

        add(jLabel);
        add(submit);
        add(userInput);


        setVisible(true);
    }

    private void submitAction() {
        // You can do some validation here before assign the text to the variable
        userWord = userInput.getText();
        sizeOfArray = Integer.parseInt(userWord);
    }


    public int getSizeOfArray() {
        return sizeOfArray;
    }
}

