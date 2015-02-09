package ru.isavin.life.txt.ru.isavin.life.model;

import java.util.Random;

/**
 * @author ilasavin
 * @since 03.02.15
 */
public class World {
    public final static int DEFAULT_WORLD_SIZE = 5;

    private Colony colony;

    public void createColony(int colonyHeight, int colonyLength) {
        this.colony = new Colony(colonyLength, colonyHeight);
    }

    public void createColony() {
        this.colony = new Colony(DEFAULT_WORLD_SIZE, DEFAULT_WORLD_SIZE);
    }

    public void populateColony() {
        Random random = new Random();
        Cell[][] colonyCells = this.colony.getCells();
        for (int i = 0; i < colonyCells.length; i++) {
            for (int j = 0; j < colonyCells[i].length; j++) {
                colonyCells[i][j] = new Cell(random.nextBoolean());
            }
        }
    }

    public void createGlider() {
        Cell[][] colonyCells = this.colony.getCells();
        for (int i = 0; i < colonyCells.length; i++) {
            for (int j = 0; j < colonyCells[i].length; j++) {
                colonyCells[i][j] = new Cell(false);
            }
        }

        colonyCells[0][1].born();
        colonyCells[1][2].born();
        colonyCells[2][2].born();
        colonyCells[2][1].born();
        colonyCells[2][0].born();
    }

    public void printColony() {
        for (Cell[] colonyCells : this.colony.getCells()) {
            for (Cell cell : colonyCells) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }

    public void changeGeneration() {
        colony.update();
    }

    public Colony getColony() {
        return colony;
    }
}
