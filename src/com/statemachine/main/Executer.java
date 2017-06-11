package com.statemachine.main;

import com.statemachine.GraphViz.*;

import java.util.ArrayList;

/**
 * Created by Amin Rashidbeigi on 1/9/2017.
 */
public class Executer {

    private int[] visited;
    private String [][][] array;
    private String [][]table;
    private String start;
    private String []finals;


    /**
     * Constructor
     * @param table the table of graph
     * @param start the starter node of graph
     * @param finals final states
     */
    public Executer(String[][] table, String start, String[]finals) {
        array = twoDtoThreeDArray(table);
        this.start = start;
        this.finals = finals;
        this.table = table;
        visited = new int[table.length];

        GraphDrawer gd = new GraphDrawer();
        gd.draw("test.", graphvizStringParser(table)); //draw (OutputFileName, GraphString)

        for (int i = 0; i < table.length; i++){
            for (int j = 0; j < table.length; j++){
                System.out.print(table[i][j]);
            }
            System.out.println();
        }


    }

    /**
     * This function detect the loops of graph. It uses the DFS algorithm
     * @param node the starter node
     * @return true if the graph has loop and false if it hasn't loop
     */
    public boolean hasLoop(int node) {
        visited[node] = 1;
        for (int j = 0; j < table.length; j++) {
            if (!table[node][j].equals("-")){
                if (visited[j] == 1) return true;
                else if (visited[j] != 2)
                    if (hasLoop(j)) return true;
            }
        }
        return false;
    }

    /**
     * This function removes all loops of graph
     */
    public void removeLoop(){
        while (hasLoop(0)){
            removeLoopAsistant(0, table);
        }
    }

    /**
     * This funcion remove a loop of graph
     * @param node its the node of DFS
     * @param table the table of graph
     */
    public void removeLoopAsistant(int node, String[][]table){
        visited[node] = 1;
        for (int j = 0; j < table.length; j++) {
            if (!table[node][j].equals("-")){
                if (visited[j] == 1) {
                    table[node][j] = "-";
                }
                else if (visited[j] != 2){
                    removeLoopAsistant(j, table);
                }
//                    if (hasLoop(j))
            }
        }
    }

    /**
     * this function parses the graphviz input String
     * @param array the table of graph
     * @return The graphviz input String
     */
    public String graphvizStringParser(String [][] array){
        String graphvizString = "{ \n";
        for (int i = 0; i < finals.length; i++){
            graphvizString += "    node [shape = doublecircle];" + finals[i] + ";\n";
        }
        graphvizString +="    node [shape = point ]; qi\n" +
                "\n" +
                "    node [shape = circle];\n" +
                "    qi -> "+ start + ";";
        for (int i = 0; i < array.length; i++){
            graphvizString += "\t" +Integer.toString(i) + " [label=" + Integer.toString(i) + "]\n";
            for (int j = 0; j < array.length; j++){
                if (!array[i][j].equals("-")){
                    graphvizString += "\t\t" +Integer.toString(i) + " -> " + Integer.toString(j);
                    graphvizString += " [label=" + array[i][j] + "]\n";
                }
            }
        }
        graphvizString += "}";
        return graphvizString;
    }


    /**
     * This funcion get the 2D table and convert it to the 3D array
     * @param table the table of graph
     * @return return the 3D array of graph
     */
    public String[][][] twoDtoThreeDArray(String [][] table) {
        String[][][] array = new String[table.length][table.length][table.length];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                array[i][j][0] = table[i][j];
                String[] charArray = table[i][j].split(",");
                if (charArray.length > 1) {
                    for (int w = 0; w < charArray.length; w++) {
                        array[i][j][w] = charArray[w];
                    }
                }
            }
        }
        return array;
    }

    public String[][][] getArray() {
        return array;
    }
}
