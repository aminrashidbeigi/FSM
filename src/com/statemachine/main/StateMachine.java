package com.statemachine.main;

/**
 * Created by Amin Rashidbeigi on 1/15/2017.
 */
public class StateMachine {

    private String[][][]array;
    private int startState;
    private int[] finalState;
    int fState;


    /**
     * Constructor
     * @param array the array of graph
     * @param startState the starter state of graph
     * @param finalState the final states of graph
     */
    public StateMachine(String[][][] array ,int startState, int[] finalState) {
        this.array = array;
        this.startState = startState;
        this.finalState = finalState;
        fState = startState;
    }

    /**
     * detect a String in the graph
     * @param searched the user search input
     * @return true if the string detects
     */
    public boolean isStringValid(String searched){
        String newSearched = searched;
        int state = findingTheFinalState(newSearched.charAt(0),0,startState, newSearched);
        for (int i = 0; i < finalState.length; i++){
            if (state == finalState[i]) return true;
        }
        return false;
    }

    /**
     * recursively detect the final states of the string in the graph
     * @param c the character to search
     * @param count the index of string character
     * @param state the present state
     * @param searched the user input search string
     * @return the final state
     */
    private int findingTheFinalState(char c, int count, int state, String searched){
        for (int j = 0; j < array.length; j++){
            for (int w = 0; w < array.length; w++){
                if (array[state][j][w] != null && c == array[state][j][w].charAt(0)){
                    count++;
                    state = j;
                    if (count > searched.length() - 1){
                        fState = state;
                        break;
                    }
                    findingTheFinalState(searched.charAt(count), count, state, searched);
                }
            }
        }
        return fState;
    }
}
