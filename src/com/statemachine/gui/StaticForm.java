package com.statemachine.gui;

import javax.swing.*;
import java.awt.*;


/**
 * @author amin
 * @version 1.0.0
 */
public class StaticForm extends JFrame {

    JLabel title, commandLabel, startStateLabel, finalStateLabel;
    JTextField searchField, startStateField, finalStateField;
    JTextArea statusField;
    JButton searchButton, graphList, hasLoop, removeLoop;
    JButton makeTheStateMachine;
    JTable table;

    /**
     * Constructor
     */
    public StaticForm() {
        setSize(600, 600);
        setLayout(null);
        // Defining Labels
        title = new JLabel("Fill the table ");
        title.setBounds(20, 15, 110, 30);
        setVisible(true);

        commandLabel = new JLabel("Enter the string to search: ");
        commandLabel.setBounds(20, 290, 200, 30);

        // Defining Name field
        searchField = new JTextField();
        searchField.setBounds(20, 330, 275, 30);


        startStateLabel = new JLabel("Start state: ");
        startStateLabel.setBounds(345, 290, 80, 30);

        startStateField = new JTextField();
        startStateField.setBounds(345, 330, 80, 30);


        finalStateLabel = new JLabel("Final States: ");
        finalStateLabel.setBounds(475, 290, 80, 30);


        finalStateField = new JTextField();
        finalStateField.setBounds(475, 330, 80, 30);



        // Defining Search Button
        searchButton = new JButton("Search");
        searchButton.setBounds(20, 380, 120, 25);
        searchButton.setBackground(new Color(240,240,241));

        // Defining Reset Button
        graphList = new JButton("Graph List");
        graphList.setBounds(168, 380, 120, 25);
        graphList.setBackground(new Color(240,240,241));

        // Defining Help Button
        hasLoop = new JButton("Has Loop");
        hasLoop.setBounds(314, 380, 120, 25);
        hasLoop.setBackground(new Color(240,240,241));

        // Defining Exit Button
        removeLoop = new JButton("Remove Loop");
        removeLoop.setBounds(455, 380, 120, 25);
        removeLoop.setBackground(new Color(240,240,241));

        String[] columnNames = new String[UserInput.sizeOfArray];

        String[][] rows = new String[UserInput.sizeOfArray][UserInput.sizeOfArray];
        for (int i = 0; i < UserInput.sizeOfArray; i++){
            for (int j = 0; j < UserInput.sizeOfArray; j++){
                rows[i][j] = "-";
            }
            columnNames[i] = i+"";
        }

        table = new JTable(rows, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        table.setBounds(20, 50, 555, 200);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.add(table);

        // Defining makeTheStateMachine Button
        makeTheStateMachine = new JButton("Make The State Machine !");
        makeTheStateMachine.setBounds(20, 260, 555, 25);
        makeTheStateMachine.setBackground(new Color(240,240,241));


        statusField = new JTextArea();
        statusField.setBounds(20, 425, 555, 125);


        // fixing all Label,TextField,RadioButton
        add(title);
        add(commandLabel);
        add(searchField);
        add(makeTheStateMachine);
        add(table);
        add(removeLoop);
        add(hasLoop);
        add(graphList);
        add(searchButton);
        add(finalStateField);
        add(startStateField);
        add(finalStateLabel);
        add(startStateLabel);
        add(statusField);


        //Displaying Frame in Center of the Screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2,
                dim.height/2-this.getSize().height/2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
}

