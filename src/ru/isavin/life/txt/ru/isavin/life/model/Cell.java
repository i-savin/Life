package ru.isavin.life.txt.ru.isavin.life.model;

/**
 * @author ilasavin
 * @since 07.02.15
 */
public class Cell {

    private boolean isAlive;

    public Cell() {
    }

    public Cell(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public void die() {
        setAlive(false);
    }

    public void born() {
        setAlive(true);
    }

    @Override
    public String toString() {
        return isAlive ? "*" : " ";
    }

}
