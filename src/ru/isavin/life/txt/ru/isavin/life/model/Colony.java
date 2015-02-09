package ru.isavin.life.txt.ru.isavin.life.model;

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
        boolean left = true,
                right = true,
                top = true,
                bottom = true;
        if (i > 0) {
            top = false;
        }
        if (i < cells.length - 1) {
            bottom = false;
        }
        if (j > 0) {
            left = false;
        }
        if (j < cells[i].length - 1) {
            right = false;
        }

        if (left) {
            if (top) {
                neighbours.add(cells[i + 1][j]);
                neighbours.add(cells[i + 1][j + 1]);
                neighbours.add(cells[i][j + 1]);
            } else if (bottom) {
                neighbours.add(cells[i - 1][j]);
                neighbours.add(cells[i - 1][j + 1]);
                neighbours.add(cells[i][j + 1]);
            } else {
                neighbours.add(cells[i - 1][j]);
                neighbours.add(cells[i - 1][j + 1]);
                neighbours.add(cells[i][j + 1]);
                neighbours.add(cells[i + 1][j + 1]);
                neighbours.add(cells[i + 1][j]);
            }
        } else if (right) {
            if (top) {
                neighbours.add(cells[i][j - 1]);
                neighbours.add(cells[i + 1][j - 1]);
                neighbours.add(cells[i + 1][j]);
            } else if (bottom) {
                neighbours.add(cells[i][j - 1]);
                neighbours.add(cells[i - 1][j - 1]);
                neighbours.add(cells[i][j - 1]);
            } else {
                neighbours.add(cells[i + 1][j]);
                neighbours.add(cells[i + 1][j - 1]);
                neighbours.add(cells[i][j - 1]);
                neighbours.add(cells[i - 1][j - 1]);
                neighbours.add(cells[i - 1][j]);
            }
        } else {
            if (top) {
                neighbours.add(cells[i][j - 1]);
                neighbours.add(cells[i][j + 1]);
                neighbours.add(cells[i + 1][j + 1]);
                neighbours.add(cells[i + 1][j]);
                neighbours.add(cells[i + 1][j - 1]);
            } else if (bottom) {
                neighbours.add(cells[i][j - 1]);
                neighbours.add(cells[i - 1][j - 1]);
                neighbours.add(cells[i - 1][j]);
                neighbours.add(cells[i - 1][j + 1]);
                neighbours.add(cells[i][j + 1]);
            } else {
                neighbours.add(cells[i - 1][j - 1]);
                neighbours.add(cells[i - 1][j]);
                neighbours.add(cells[i - 1][j + 1]);
                neighbours.add(cells[i][j + 1]);
                neighbours.add(cells[i + 1][j + 1]);
                neighbours.add(cells[i + 1][j]);
                neighbours.add(cells[i + 1][j - 1]);
                neighbours.add(cells[i][j - 1]);
            }
        }

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
                if (cells[i][j].isAlive()) {
                    if (getLiveNeighboursCount(i, j) > 3 || getLiveNeighboursCount(i, j) < 2) {
                        newCells[i][j].die();
                    }
                } else {
                    if (getLiveNeighboursCount(i, j) == 3) {
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
