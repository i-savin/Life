package ru.isavin.life.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ilasavin
 * @since 06.02.15.
 */
public class Colony {
    private Cell[][] cells;

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
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                int liveNeighboursCount = getLiveNeighboursCount(i, j);

                if (cells[i][j].isAlive()) {
                    if (liveNeighboursCount > 3) {
                        newCells[i][j].die();
                    } else if (liveNeighboursCount < 2) {
                        newCells[i][j].die();
                    }
                } else {
                    if (liveNeighboursCount == 3) {
                        newCells[i][j].born();
                    }
                }
            }
        }
        cells = newCells;
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
}
