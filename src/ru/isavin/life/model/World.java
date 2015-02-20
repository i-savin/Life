package ru.isavin.life.model;

import java.util.Random;

/**
 * @author ilasavin
 * @since 03.02.15
 */
public class World {
    public final static int DEFAULT_WORLD_SIZE = 5;

    private Colony colony;

    private int generationsNumber = 0;

    public void createColony(int colonyHeight, int colonyLength) {
        this.colony = new Colony(colonyHeight, colonyLength);
        Cell[][] colonyCells = this.colony.getCells();
        for (int i = 0; i < colonyCells.length; i++) {
            for (int j = 0; j < colonyCells[i].length; j++) {
                colonyCells[i][j] = new Cell(false);
            }
        }
    }

    public void createColony() {
        createColony(DEFAULT_WORLD_SIZE, DEFAULT_WORLD_SIZE);
    }

    public void populateColony() {
        Random random = new Random();
        Cell[][] colonyCells = this.colony.getCells();
        for (int i = 0; i < colonyCells.length; i++) {
            for (int j = 0; j < colonyCells[i].length; j++) {
                colonyCells[i][j] = new Cell(random.nextBoolean());
                if (this.colony.isColonyDead() && colonyCells[i][j].isAlive()) {
                    this.colony.setColonyDead(false);
                }
            }
        }
    }

    public void createGlider(int row, int column) {
        Cell[][] colonyCells = this.colony.getCells();
        this.colony.bornCell(row, (column + 1) % colonyCells[0].length);
        this.colony.bornCell((row + 1) % colonyCells.length, (column + 2) % colonyCells[0].length);
        this.colony.bornCell((row + 2) % colonyCells.length, (column + 2) % colonyCells[0].length);
        this.colony.bornCell((row + 2) % colonyCells.length, (column + 1) % colonyCells[0].length);
        this.colony.bornCell((row + 2) % colonyCells.length, column);
        this.colony.setColonyDead(false);
    }

    public void createGliderGun(int row, int column) {
        Cell[][] colonyCells = this.colony.getCells();
        this.colony.bornCell((row + 5) % colonyCells.length, (column + 1) % colonyCells[0].length);
        this.colony.bornCell((row + 5) % colonyCells.length, (column + 2) % colonyCells[0].length);
        this.colony.bornCell((row + 6) % colonyCells.length, (column + 1) % colonyCells[0].length);
        this.colony.bornCell((row + 6) % colonyCells.length, (column + 2) % colonyCells[0].length);

        this.colony.bornCell((row + 5) % colonyCells.length, (column + 11) % colonyCells[0].length);
        this.colony.bornCell((row + 6) % colonyCells.length, (column + 11) % colonyCells[0].length);
        this.colony.bornCell((row + 7) % colonyCells.length, (column + 11) % colonyCells[0].length);

        this.colony.bornCell((row + 4) % colonyCells.length, (column + 12) % colonyCells[0].length);
        this.colony.bornCell((row + 8) % colonyCells.length, (column + 12) % colonyCells[0].length);

        this.colony.bornCell((row + 3) % colonyCells.length, (column + 13) % colonyCells[0].length);
        this.colony.bornCell((row + 9) % colonyCells.length, (column + 13) % colonyCells[0].length);

        this.colony.bornCell((row + 3) % colonyCells.length, (column + 14) % colonyCells[0].length);
        this.colony.bornCell((row + 9) % colonyCells.length, (column + 14) % colonyCells[0].length);

        this.colony.bornCell((row + 6) % colonyCells.length, (column + 15) % colonyCells[0].length);

        this.colony.bornCell((row + 4) % colonyCells.length, (column + 16) % colonyCells[0].length);
        this.colony.bornCell((row + 8) % colonyCells.length, (column + 16) % colonyCells[0].length);

        this.colony.bornCell((row + 5) % colonyCells.length, (column + 17) % colonyCells[0].length);
        this.colony.bornCell((row + 6) % colonyCells.length, (column + 17) % colonyCells[0].length);
        this.colony.bornCell((row + 7) % colonyCells.length, (column + 17) % colonyCells[0].length);

        this.colony.bornCell((row + 6) % colonyCells.length, (column + 18) % colonyCells[0].length);

        this.colony.bornCell((row + 3) % colonyCells.length, (column + 21) % colonyCells[0].length);
        this.colony.bornCell((row + 4) % colonyCells.length, (column + 21) % colonyCells[0].length);
        this.colony.bornCell((row + 5) % colonyCells.length, (column + 21) % colonyCells[0].length);
        this.colony.bornCell((row + 3) % colonyCells.length, (column + 22) % colonyCells[0].length);
        this.colony.bornCell((row + 4) % colonyCells.length, (column + 22) % colonyCells[0].length);
        this.colony.bornCell((row + 5) % colonyCells.length, (column + 22) % colonyCells[0].length);

        this.colony.bornCell((row + 2) % colonyCells.length, (column + 23) % colonyCells[0].length);
        this.colony.bornCell((row + 6) % colonyCells.length, (column + 23) % colonyCells[0].length);

        this.colony.bornCell((row + 2) % colonyCells.length, (column + 25) % colonyCells[0].length);
        this.colony.bornCell((row + 1) % colonyCells.length, (column + 25) % colonyCells[0].length);
        this.colony.bornCell((row + 6) % colonyCells.length, (column + 25) % colonyCells[0].length);
        this.colony.bornCell((row + 7) % colonyCells.length, (column + 25) % colonyCells[0].length);

        this.colony.bornCell((row + 4) % colonyCells.length, (column + 35) % colonyCells[0].length);
        this.colony.bornCell((row + 5) % colonyCells.length, (column + 35) % colonyCells[0].length);
        this.colony.bornCell((row + 4) % colonyCells.length, (column + 36) % colonyCells[0].length);
        this.colony.bornCell((row + 5) % colonyCells.length, (column + 36) % colonyCells[0].length);
        this.colony.setColonyDead(false);
    }

    public void createDiehard(int row, int column) {
        Cell[][] colonyCells = this.colony.getCells();

        this.colony.bornCell(row, column);
        this.colony.bornCell(row, (column + 1) % colonyCells[0].length);
        this.colony.bornCell((row + 1) % colonyCells.length, (column + 1) % colonyCells[0].length);

        this.colony.bornCell((row + 1) % colonyCells.length, (column + 5) % colonyCells[0].length);
        this.colony.bornCell((row + 1) % colonyCells.length, (column + 6) % colonyCells[0].length);
        this.colony.bornCell((row - 1) % colonyCells.length, (column + 6) % colonyCells[0].length);
        this.colony.bornCell((row + 1) % colonyCells.length, (column + 7) % colonyCells[0].length);
        this.colony.setColonyDead(false);
    }

    public void createAcorn(int row, int column) {
        Cell[][] colonyCells = this.colony.getCells();

        this.colony.bornCell(row, (column + 1) % colonyCells[0].length);
        this.colony.bornCell(row, (column + 2) % colonyCells[0].length);
        this.colony.bornCell((row - 2) % colonyCells.length, (column + 2) % colonyCells[0].length);

        this.colony.bornCell((row - 1) % colonyCells.length, (column + 4) % colonyCells[0].length);

        this.colony.bornCell(row, (column + 5) % colonyCells[0].length);
        this.colony.bornCell(row, (column + 6) % colonyCells[0].length);
        this.colony.bornCell(row, (column + 7) % colonyCells[0].length);
        this.colony.setColonyDead(false);
    }

    public void createLineColony(int row, int column) {
        Cell[][] colonyCells = this.colony.getCells();


        this.colony.bornCell(row, (column + 2) % colonyCells[0].length);
        this.colony.bornCell(row, (column + 3) % colonyCells[0].length);
        this.colony.bornCell(row, (column + 4) % colonyCells[0].length);
        this.colony.bornCell(row, (column + 5) % colonyCells[0].length);
        this.colony.bornCell(row, (column + 7) % colonyCells[0].length);
        this.colony.bornCell(row, (column + 6) % colonyCells[0].length);
        this.colony.bornCell(row, (column + 7) % colonyCells[0].length);
        this.colony.bornCell(row, (column + 8) % colonyCells[0].length);
        this.colony.bornCell(row, (column + 9) % colonyCells[0].length);

        this.colony.bornCell(row, (column + 11) % colonyCells[0].length);
        this.colony.bornCell(row, (column + 12) % colonyCells[0].length);
        this.colony.bornCell(row, (column + 13) % colonyCells[0].length);
        this.colony.bornCell(row, (column + 14) % colonyCells[0].length);
        this.colony.bornCell(row, (column + 15) % colonyCells[0].length);

        this.colony.bornCell(row, (column + 18) % colonyCells[0].length);
        this.colony.bornCell(row, (column + 19) % colonyCells[0].length);
        this.colony.bornCell(row, (column + 20) % colonyCells[0].length);

        this.colony.bornCell(row, (column + 26) % colonyCells[0].length);
        this.colony.bornCell(row, (column + 27) % colonyCells[0].length);
        this.colony.bornCell(row, (column + 28) % colonyCells[0].length);
        this.colony.bornCell(row, (column + 29) % colonyCells[0].length);
        this.colony.bornCell(row, (column + 30) % colonyCells[0].length);
        this.colony.bornCell(row, (column + 31) % colonyCells[0].length);
        this.colony.bornCell(row, (column + 32) % colonyCells[0].length);

        this.colony.bornCell(row, (column + 34) % colonyCells[0].length);
        this.colony.bornCell(row, (column + 35) % colonyCells[0].length);
        this.colony.bornCell(row, (column + 36) % colonyCells[0].length);
        this.colony.bornCell(row, (column + 37) % colonyCells[0].length);
        this.colony.bornCell(row, (column + 38) % colonyCells[0].length);
        this.colony.setColonyDead(false);
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
        generationsNumber++;
    }

    public String getColonyInformation() {
        StringBuffer sb = new StringBuffer();
        sb.append("Lived generations: ")
                .append(generationsNumber)
                .append("\nBorn cells: ")
                .append(colony.getNewBornNumber())
                .append("\nDied cells: ")
                .append(colony.getDiedNumber());
        return sb.toString();
    }

    public int getGenerationsNumber() {
        return generationsNumber;
    }

    public boolean colonyIsAlive() {
        return !this.colony.isColonyDead();
    }

    public Colony getColony() {
        return colony;
    }
}
