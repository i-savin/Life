package ru.isavin.life.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ilasavin
 * @since 06.02.15.
 */

//TODO научиться определять минимальную цикличность
//TODO научиться определять цикличность поколений - хэш-код?

public class Colony {
    private Cell[][] cells;
    private boolean colonyDead = true;
    private int newBornNumber = 0;
    private int diedNumber = 0;

    public Colony(int length, int height) {
        cells = new Cell[length][height];
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public List<Cell> getNeighbours(int i, int j) {
        List<Cell> neighbours = new ArrayList<Cell>();
        int minusLine = i - 1;
        int minusRow = j - 1;
        neighbours.add(cells[i][(j + 1) % cells[i].length]);
        neighbours.add(cells[(i + 1) % cells.length][(j + 1) % cells[i].length]);
        neighbours.add(cells[(i + 1) % cells.length][j]);
        neighbours.add(cells[(i + 1) % cells.length][minusRow < 0 ? cells[i].length - 1 : minusRow]);
        neighbours.add(cells[i][minusRow < 0 ? cells[i].length - 1 : minusRow]);
        neighbours.add(cells[minusLine < 0 ? cells.length - 1 : minusLine][minusRow < 0 ? cells[i].length - 1 : minusRow]);
        neighbours.add(cells[minusLine < 0 ? cells.length - 1 : minusLine][j]);
        neighbours.add(cells[minusLine < 0 ? cells.length - 1 : minusLine][(j + 1) % cells[i].length]);
        return neighbours;
    }

    public int getLiveNeighboursCount(int i, int j) {
        List<Cell> neighbours = getNeighbours(i, j);
        int liveNeighboursCount = 0;
        for (Cell cell : neighbours) {
            if (cell.isAlive()) {
                liveNeighboursCount++;
            }
        }
        return liveNeighboursCount;
    }

    public void update() {
        Colony newColony = new Colony(cells.length, cells[0].length);
        Cell[][] newCells = copyColony();
        newColony.setCells(newCells);

        boolean allCellsAreDead = true;
        for (int i = 0; i < newCells.length; i++) {
            for (int j = 0; j < newCells[i].length; j++) {
                int liveNeighboursCount = newColony.getLiveNeighboursCount(i, j);
                int liveCells = newCells[i][j].isAlive() ? liveNeighboursCount + 1 : liveNeighboursCount;
                if (liveCells == 3) {
                    bornCell(i, j);

                } else if (liveCells != 4) {
                    killCell(i, j);
                }
                if (newCells[i][j].isAlive()) {
                    allCellsAreDead = false;
                }

            }
        }
        colonyDead = allCellsAreDead;
    }

    private Cell[][] copyColony() {
        Cell[][] newColony = new Cell[cells.length][cells[0].length];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                newColony[i][j] = new Cell(cells[i][j].isAlive());
            }
        }
        return newColony;
    }

    public boolean isColonyDead() {
        return colonyDead;
    }

    public void setColonyDead(boolean colonyDead) {
        this.colonyDead = colonyDead;
    }

    public int getNewBornNumber() {
        return newBornNumber;
    }

    public int getDiedNumber() {
        return diedNumber;
    }

    public void bornCell(int i, int j) {
        if (!cells[i][j].isAlive()) {
            this.newBornNumber++;
        }
        cells[i][j].born();
    }

    public void killCell(int i, int j) {
        if (cells[i][j].isAlive()) {
            this.diedNumber++;
        }
        cells[i][j].die();
    }

    public int getHash() {
        int hash = 0;
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                hash ^= i * j * (cells[i][j].isAlive() ? 13 : 7);
            }
        }
        return hash;
    }
}
