package com.statemachine.gui;

import com.statemachine.main.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/**
 * @author amin
 * @version 1.0.0
 */

public class DynamicForm extends StaticForm {

    StateMachine sm;
    ArrayList<String> commandList;
    Executer ex;
    String gender = "";
    String SHOW = "Show";
    String commandType;
    int commandIndex = 0;
    private String helpContent;
    private String[][] tableArray;

    /**
     * Constructor
     */
    public DynamicForm(){

        searchButton.addActionListener(new AbstractAction(SHOW){
            public void actionPerformed(ActionEvent ae) {
                if (searchField.getText()!= null && searchField.getText().length() > 0){
                    String isStringValid = (sm.isStringValid(searchField.getText()))? "true" : "false";
                    statusField.setText(isStringValid);
                } else{
                    statusField.setText("NULL");

                }

            }
        });

        removeLoop.addActionListener(new AbstractAction(SHOW){
            public void actionPerformed(ActionEvent ae) {
                ex.removeLoop();
                statusField.setText("Loops successfully removed.");
            }
        });

        graphList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GraphListCreator glc = new GraphListCreator(ex.getArray());
                statusField.setText(glc.getList());
            }
        });

        hasLoop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = ex.hasLoop(0) ? "true" : "false";
                statusField.setText(s);
//                JOptionPane.showMessageDialog(null, helpContent, "Help", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        makeTheStateMachine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableArray = new String[UserInput.sizeOfArray][UserInput.sizeOfArray];
                for (int i = 0; i < UserInput.sizeOfArray; i++){
                    for (int j = 0; j < UserInput.sizeOfArray; j++){
                        tableArray[i][j] = table.getModel().getValueAt(i,j).toString();
                    }
                }
                String[] finals = finalStateField.getText().split(",");
                int [] finalStates = new int[finals.length];
                for (int i = 0; i < finals.length; i++)
                    finalStates[i] = Integer.parseInt(finals[i]);
                ex = new Executer(tableArray, startStateField.getText(), finals);
                sm = new StateMachine(ex.getArray(), Integer.parseInt(startStateField.getText()), finalStates);
            }
        });

        searchField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commandType = searchField.getText();
                commandList.add(commandType);
                commandIndex++;
                System.out.println(commandType);
//                ex.commandCaller(commandType);
            }
        });
    }


    /**
     * Main function of Program
     */
    public static void main(String[] args) {
        UserInput ui = new UserInput();
    }

    public String[][] getTableArray() {
        return tableArray;
    }
}
