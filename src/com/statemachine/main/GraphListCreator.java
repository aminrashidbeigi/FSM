package com.statemachine.main;

/**
 * Created by Amin Rashidbeigi on 1/14/2017.
 */
public class GraphListCreator {

    private String[][][] array;
    private String list;

    /**
     * Constructor
     * @param array the 3D array of graph
     */
    public GraphListCreator(String[][][] array) {
        this.array = array;
        list = graphListGenerator();
    }

    /**
     * this function parses a string that contains the graph list
     * @return the graph list String
     */
    private String graphListGenerator(){
        String list = "";

        for (int i = 0; i < array.length; i++){
            list += Integer.toString(i) + " -> ";
            for (int j = 0; j < array.length; j++){
                for (int w = 0; w < array.length ; w++){
                    if (array[i][j][w] != null){
                        if (!array[i][j][w].equals("-"))
                            list += "(" + j + " , " + array[i][j][w] + ")";
                    }
                }
            }
            list += "\n";
        }
        return list;
    }

    public String getList() {
        return list;
    }
}
