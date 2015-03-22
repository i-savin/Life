package ru.isavin.life.grafic;

/**
 * @author ilasavin
 * @since 22.03.15
 */
public class CellImage {

    private int x;
    private int y;

    public CellImage(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
