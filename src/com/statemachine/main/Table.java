package com.statemachine.main;

/**
 * Created by Amin Rashidbeigi on 1/9/2017.
 */
public class Table {

    private int[][] table;

    public Table(int size) {
        table = new int[size][size];
    }

    public int[][] getTable() {
        return table;
    }
}
