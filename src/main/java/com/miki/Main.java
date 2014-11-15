package com.miki;

/**
 * Created by Miki on 11/15/2014.
 */
public class Main {
    /**
     * - - - -
     * - x x x
     * x x x -
     * - - - -
     *
     * @param args
     */

    public static void main(String[] args) {

        GridController gridController = new GridController();
        gridController.addCell(new Cell(3, 4));
        gridController.addCell(new Cell(4, 3));
        gridController.addCell(new Cell(4, 4));
        gridController.addCell(new Cell(4, 5));
        gridController.generateGenerations(100);
    }
}
