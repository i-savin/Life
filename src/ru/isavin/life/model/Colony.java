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
        Cell[][] newCells = copyColony();
        boolean allCellsAreDead = true;
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                int liveNeighboursCount = getLiveNeighboursCount(i, j);
                int liveCells = cells[i][j].isAlive() ? liveNeighboursCount + 1 : liveNeighboursCount;
                if (liveCells == 3) {
                    newCells[i][j].born();
                } else if (liveCells != 4) {
                    newCells[i][j].die();
                }
                if (newCells[i][j].isAlive()) {
                    allCellsAreDead = false;
                }

            }
        }
        cells = newCells;
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
