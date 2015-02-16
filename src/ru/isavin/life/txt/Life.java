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
        world.createGlider(22, 152);
//        world.createGliderGun(15, 130);
//        world.createDiehard(43, 152);
//        world.createAcorn(43, 152);
//        world.createLineColony(20,140);
        world.printColony();
        System.out.print("\033[H\033[2J");

//        world.liveUntilCycle();

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
