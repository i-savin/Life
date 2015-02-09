package ru.isavin.life.txt;

import ru.isavin.life.txt.ru.isavin.life.model.World;

import java.io.IOException;

/**
 * @author ilasavin
 * @since 03.02.15
 */
public class Life {

    public static final int INTERVAL = 1000 / 20;

    public static void main(String[] args) throws IOException {
        World world = new World();
        world.createColony(20, 20);
//        world.populateColony();
        world.createGlider();
        world.printColony();


//        System.out.println(-1 % 5);

        for (int i = 0; i < 1000; i++) {
            world.changeGeneration();
            world.printColony();
            try {
                Thread.sleep(INTERVAL);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
