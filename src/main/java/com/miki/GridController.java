package com.miki;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Miki on 11/15/2014.
 */
public class GridController {


    private List<Cell> cellsList = new ArrayList<Cell>();



    public void generateGenerations(int n) {
        System.out.println(this.toString());
        for (int i = 0; i < n; i++) {
            System.out.println(this.nextGeneration());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String nextGeneration() {
        if (this.cellsList.size() > 0) {
            List<Cell> remainingCells = new ArrayList<Cell>();
            for (int i = getSmallestCellByLine().getLine() - 1; i <= getBiggestByLine().getLine() + 1; i++) {
                for (int j = getSmallestCellByColumn().getColumn() - 1; j <= getBiggestByColumn().getColumn() + 1; j++) {

                    int count = 0;
                    for (int iNeighB = i - 1; iNeighB <= i + 1; iNeighB++) {
                        for (int jNeight = j - 1; jNeight <= j + 1; jNeight++) {
                            if (i == iNeighB && j == jNeight) {

                            } else {
                                if (this.cellsList.contains(new Cell(iNeighB, jNeight))) {
                                    count++;
                                }
                            }

                        }
                    }

                    if ((count == 2 && this.cellsList.contains(new Cell(i, j))) || count == 3) {
                        remainingCells.add(new Cell(i, j));
                    }

                }

            }
            cellsList.clear();
            cellsList.addAll(remainingCells);
        }


        return toString();
    }

    public Boolean addCell(Cell cell) {
        if (cellsList.contains(cell)) {
            return false;
        }
        cellsList.add(cell);
        return true;
    }

    public Cell getSmallestCellByLine() {
        Cell result = null;
        int smallLine = Integer.MAX_VALUE;
        for (Cell cell : cellsList) {
            if (cell.getLine() < smallLine) {
                smallLine = cell.getLine();
                result = cell;
            }
        }
        return result;
    }

    public Cell getSmallestCellByColumn() {

        Cell result = null;
        int smallCol = Integer.MAX_VALUE;
        for (Cell cell : cellsList) {
            if (cell.getColumn() < smallCol) {
                smallCol = cell.getColumn();
                result = cell;
            }
        }
        return result;
    }

    public Cell getBiggestByLine() {
        Cell result = null;
        int smallLine = Integer.MIN_VALUE;
        for (Cell cell : cellsList) {
            if (cell.getLine() > smallLine) {
                smallLine = cell.getLine();
                result = cell;
            }
        }
        return result;
    }


    public Cell getBiggestByColumn() {
        Cell result = null;
        int smallCol = Integer.MIN_VALUE;
        for (Cell cell : cellsList) {
            if (cell.getColumn() > smallCol) {
                smallCol = cell.getColumn();
                result = cell;
            }
        }
        return result;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        if (this.cellsList.size() > 0) {
            for (int i = getSmallestCellByLine().getLine() - 2; i <= getBiggestByLine().getLine() + 2; i++) {
                for (int j = getSmallestCellByColumn().getColumn() - 2; j <= getBiggestByColumn().getColumn() + 2; j++) {
                    if (cellsList.contains(new Cell(i, j))) {
                        builder.append(" x ");
                    } else {
                        builder.append("  ");
                    }
                }
                builder.append("\r\n");
            }
        }

        return builder.toString();
    }
}
