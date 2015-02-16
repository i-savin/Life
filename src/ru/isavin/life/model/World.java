package ru.isavin.life.model;

import ru.isavin.life.txt.Life;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author ilasavin
 * @since 03.02.15
 */
public class World {
    public final static int DEFAULT_WORLD_SIZE = 5;

    private Colony colony;

    private Set<Integer> hashs = new HashSet<Integer>();

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
        colonyCells[row][(column + 1) % colonyCells[0].length].born();
        colonyCells[(row + 1) % colonyCells.length][(column + 2) % colonyCells[0].length].born();
        colonyCells[(row + 2) % colonyCells.length][(column + 2) % colonyCells[0].length].born();
        colonyCells[(row + 2) % colonyCells.length][(column + 1) % colonyCells[0].length].born();
        colonyCells[(row + 2) % colonyCells.length][column].born();
        this.colony.setColonyDead(false);
    }

    public void createGliderGun(int row, int column) {
        Cell[][] colonyCells = this.colony.getCells();
        colonyCells[(row + 5) % colonyCells.length][(column + 1) % colonyCells[0].length].born();
        colonyCells[(row + 5) % colonyCells.length][(column + 2) % colonyCells[0].length].born();
        colonyCells[(row + 6) % colonyCells.length][(column + 1) % colonyCells[0].length].born();
        colonyCells[(row + 6) % colonyCells.length][(column + 2) % colonyCells[0].length].born();

        colonyCells[(row + 5) % colonyCells.length][(column + 11) % colonyCells[0].length].born();
        colonyCells[(row + 6) % colonyCells.length][(column + 11) % colonyCells[0].length].born();
        colonyCells[(row + 7) % colonyCells.length][(column + 11) % colonyCells[0].length].born();

        colonyCells[(row + 4) % colonyCells.length][(column + 12) % colonyCells[0].length].born();
        colonyCells[(row + 8) % colonyCells.length][(column + 12) % colonyCells[0].length].born();

        colonyCells[(row + 3) % colonyCells.length][(column + 13) % colonyCells[0].length].born();
        colonyCells[(row + 9) % colonyCells.length][(column + 13) % colonyCells[0].length].born();

        colonyCells[(row + 3) % colonyCells.length][(column + 14) % colonyCells[0].length].born();
        colonyCells[(row + 9) % colonyCells.length][(column + 14) % colonyCells[0].length].born();

        colonyCells[(row + 6) % colonyCells.length][(column + 15) % colonyCells[0].length].born();

        colonyCells[(row + 4) % colonyCells.length][(column + 16) % colonyCells[0].length].born();
        colonyCells[(row + 8) % colonyCells.length][(column + 16) % colonyCells[0].length].born();

        colonyCells[(row + 5) % colonyCells.length][(column + 17) % colonyCells[0].length].born();
        colonyCells[(row + 6) % colonyCells.length][(column + 17) % colonyCells[0].length].born();
        colonyCells[(row + 7) % colonyCells.length][(column + 17) % colonyCells[0].length].born();

        colonyCells[(row + 6) % colonyCells.length][(column + 18) % colonyCells[0].length].born();

        colonyCells[(row + 3) % colonyCells.length][(column + 21) % colonyCells[0].length].born();
        colonyCells[(row + 4) % colonyCells.length][(column + 21) % colonyCells[0].length].born();
        colonyCells[(row + 5) % colonyCells.length][(column + 21) % colonyCells[0].length].born();
        colonyCells[(row + 3) % colonyCells.length][(column + 22) % colonyCells[0].length].born();
        colonyCells[(row + 4) % colonyCells.length][(column + 22) % colonyCells[0].length].born();
        colonyCells[(row + 5) % colonyCells.length][(column + 22) % colonyCells[0].length].born();

        colonyCells[(row + 2) % colonyCells.length][(column + 23) % colonyCells[0].length].born();
        colonyCells[(row + 6) % colonyCells.length][(column + 23) % colonyCells[0].length].born();

        colonyCells[(row + 2) % colonyCells.length][(column + 25) % colonyCells[0].length].born();
        colonyCells[(row + 1) % colonyCells.length][(column + 25) % colonyCells[0].length].born();
        colonyCells[(row + 6) % colonyCells.length][(column + 25) % colonyCells[0].length].born();
        colonyCells[(row + 7) % colonyCells.length][(column + 25) % colonyCells[0].length].born();

        colonyCells[(row + 4) % colonyCells.length][(column + 35) % colonyCells[0].length].born();
        colonyCells[(row + 5) % colonyCells.length][(column + 35) % colonyCells[0].length].born();
        colonyCells[(row + 4) % colonyCells.length][(column + 36) % colonyCells[0].length].born();
        colonyCells[(row + 5) % colonyCells.length][(column + 36) % colonyCells[0].length].born();
        this.colony.setColonyDead(false);
    }

    public void createDiehard(int row, int column) {
        Cell[][] colonyCells = this.colony.getCells();

        colonyCells[row][column].born();
        colonyCells[row][(column + 1) % colonyCells[0].length].born();
        colonyCells[(row + 1) % colonyCells.length][(column + 1) % colonyCells[0].length].born();

        colonyCells[(row + 1) % colonyCells.length][(column + 5) % colonyCells[0].length].born();
        colonyCells[(row + 1) % colonyCells.length][(column + 6) % colonyCells[0].length].born();
        colonyCells[(row - 1) % colonyCells.length][(column + 6) % colonyCells[0].length].born();
        colonyCells[(row + 1) % colonyCells.length][(column + 7) % colonyCells[0].length].born();
        this.colony.setColonyDead(false);
    }

    public void createAcorn(int row, int column) {
        Cell[][] colonyCells = this.colony.getCells();

        colonyCells[row][(column + 1) % colonyCells[0].length].born();
        colonyCells[row][(column + 2) % colonyCells[0].length].born();
        colonyCells[(row - 2) % colonyCells.length][(column + 2) % colonyCells[0].length].born();

        colonyCells[(row - 1) % colonyCells.length][(column + 4) % colonyCells[0].length].born();

        colonyCells[row][(column + 5) % colonyCells[0].length].born();
        colonyCells[row][(column + 6) % colonyCells[0].length].born();
        colonyCells[row][(column + 7) % colonyCells[0].length].born();
        this.colony.setColonyDead(false);
    }

    public void createLineColony(int row, int column) {
        Cell[][] colonyCells = this.colony.getCells();

        colonyCells[row][(column + 2) % colonyCells[0].length].born();
        colonyCells[row][(column + 3) % colonyCells[0].length].born();
        colonyCells[row][(column + 4) % colonyCells[0].length].born();
        colonyCells[row][(column + 5) % colonyCells[0].length].born();
        colonyCells[row][(column + 6) % colonyCells[0].length].born();
        colonyCells[row][(column + 7) % colonyCells[0].length].born();
        colonyCells[row][(column + 8) % colonyCells[0].length].born();
        colonyCells[row][(column + 9) % colonyCells[0].length].born();

        colonyCells[row][(column + 11) % colonyCells[0].length].born();
        colonyCells[row][(column + 12) % colonyCells[0].length].born();
        colonyCells[row][(column + 13) % colonyCells[0].length].born();
        colonyCells[row][(column + 14) % colonyCells[0].length].born();
        colonyCells[row][(column + 15) % colonyCells[0].length].born();

        colonyCells[row][(column + 18) % colonyCells[0].length].born();
        colonyCells[row][(column + 19) % colonyCells[0].length].born();
        colonyCells[row][(column + 20) % colonyCells[0].length].born();

        colonyCells[row][(column + 26) % colonyCells[0].length].born();
        colonyCells[row][(column + 27) % colonyCells[0].length].born();
        colonyCells[row][(column + 28) % colonyCells[0].length].born();
        colonyCells[row][(column + 29) % colonyCells[0].length].born();
        colonyCells[row][(column + 30) % colonyCells[0].length].born();
        colonyCells[row][(column + 31) % colonyCells[0].length].born();
        colonyCells[row][(column + 32) % colonyCells[0].length].born();

        colonyCells[row][(column + 34) % colonyCells[0].length].born();
        colonyCells[row][(column + 35) % colonyCells[0].length].born();
        colonyCells[row][(column + 36) % colonyCells[0].length].born();
        colonyCells[row][(column + 37) % colonyCells[0].length].born();
        colonyCells[row][(column + 38) % colonyCells[0].length].born();
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
    }

    public void liveUntilCycle() {
        while (hashs.add(colony.getHash())) {
            colony.update();
            printColony();
            try {
                Thread.sleep(Life.INTERVAL);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(hashs);
    }

    public boolean colonyIsAlive() {
        return !this.colony.isColonyDead();
    }

    public Colony getColony() {
        return colony;
    }
}
