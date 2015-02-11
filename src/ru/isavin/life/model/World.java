package ru.isavin.life.model;

import java.util.Random;

/**
 * @author ilasavin
 * @since 03.02.15
 */
public class World {
    public final static int DEFAULT_WORLD_SIZE = 5;

    private Colony colony;

    public void createColony(int colonyHeight, int colonyLength) {
        this.colony = new Colony(colonyHeight, colonyLength);
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

    public void createGliderGun() {
        Cell[][] colonyCells = this.colony.getCells();
        for (int i = 0; i < colonyCells.length; i++) {
            for (int j = 0; j < colonyCells[i].length; j++) {
                colonyCells[i][j] = new Cell(false);
            }
        }
        colonyCells[5][1].born();
        colonyCells[5][2].born();
        colonyCells[6][1].born();
        colonyCells[6][2].born();

        colonyCells[5][11].born();
        colonyCells[6][11].born();
        colonyCells[7][11].born();

        colonyCells[4][12].born();
        colonyCells[8][12].born();

        colonyCells[3][13].born();
        colonyCells[9][13].born();

        colonyCells[3][14].born();
        colonyCells[9][14].born();

        colonyCells[6][15].born();

        colonyCells[4][16].born();
        colonyCells[8][16].born();

        colonyCells[5][17].born();
        colonyCells[6][17].born();
        colonyCells[7][17].born();

        colonyCells[6][18].born();

        colonyCells[3][21].born();
        colonyCells[4][21].born();
        colonyCells[5][21].born();
        colonyCells[3][22].born();
        colonyCells[4][22].born();
        colonyCells[5][22].born();

        colonyCells[2][23].born();
        colonyCells[6][23].born();

        colonyCells[2][25].born();
        colonyCells[1][25].born();
        colonyCells[6][25].born();
        colonyCells[7][25].born();

        colonyCells[4][35].born();
        colonyCells[5][35].born();
        colonyCells[4][36].born();
        colonyCells[5][36].born();
    }

    public void createDiehard() {
        Cell[][] colonyCells = this.colony.getCells();
        for (int i = 0; i < colonyCells.length; i++) {
            for (int j = 0; j < colonyCells[i].length; j++) {
                colonyCells[i][j] = new Cell(false);
            }
        }

        int startRow = this.colony.getCells().length / 2;
        int startColumn = this.colony.getCells()[0].length / 4;

        colonyCells[startRow][startColumn].born();
        colonyCells[startRow][startColumn + 1].born();
        colonyCells[startRow + 1][startColumn + 1].born();

        colonyCells[startRow + 1][startColumn + 5].born();
        colonyCells[startRow + 1][startColumn + 6].born();
        colonyCells[startRow - 1][startColumn + 6].born();
        colonyCells[startRow + 1][startColumn + 7].born();

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
