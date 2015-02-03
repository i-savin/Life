package ru.isavin.life.txt;

/**
 * Created by ilasavin on 03.02.15.
 */
public class World {
    public final static int DEFAULT_WORLD_SIZE = 50;

    private boolean[][] field;

    public World() {
        this.field = new boolean[DEFAULT_WORLD_SIZE][DEFAULT_WORLD_SIZE];
    }

    public World(int length, int height) {
        this.field = new boolean[length][height];
    }

    public boolean[][] getField() {
        return field;
    }
}
