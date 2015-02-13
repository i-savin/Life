package ru.isavin.life.txt;

import ru.isavin.life.model.World;

import java.io.IOException;

/**
 * @author ilasavin
 * @since 03.02.15
 */
public class Life {

    public static final int INTERVAL = 1000 / 20;

    public static void main(String[] args) throws IOException {
        World world = new World();
        world.createColony(44, 153);
//        world.populateColony();
//        world.createGlider();
//        world.createGliderGun();
        world.createDiehard();
//        world.createAcorn();
//        world.createLineColony();
        world.printColony();
        System.out.print("\033[H\033[2J");

        while (world.colonyIsAlive()) {
            world.changeGeneration();
            world.printColony();
            try {
                Thread.sleep(INTERVAL);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("\033[H\033[2J");
        }
    }

}
